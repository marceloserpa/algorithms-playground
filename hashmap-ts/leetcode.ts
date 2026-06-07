class Entry {
    constructor(
        public key :number,
        public value : number,
        public next: Entry | null = null
    ){}
}

class MyMap {

    private capacity :number;
    private buckets: (Entry | null)[];

    constructor(capacity = 400){
        this.capacity = capacity;
        this.buckets = new Array(capacity).fill(null);
    }

    private hash(key: number): number {
        const hash :number = Math.abs(key) % this.capacity;
        return hash;
    }

    public put(key: number, value: number): void {
        const index: number = this.hash(key);
        if(this.buckets[index] == null) {
            this.buckets[index] = new Entry(key, value);
            return;
        }

        //console.log("============>>>>  Collision Detected!!!")
        let entry = this.buckets[index]!;
        if(entry.key === key) {
            entry.value = value;
            return;
        }
        while (entry.next !== null) {
            if (entry.key === key) {
          //      console.log(`Already exists: updating value for key = ${key}`);
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        if (entry.key === key) {
            //console.log(`Already exists: updating value for key = ${key}`);
            entry.value = value;
            return;
        }

        entry.next = new Entry(key, value);

    }

    public get(key :number): number {
        const index = this.hash(key);
        let entry = this.buckets[index];

        if (entry === null) {
            return null;
        }

        if (entry.key === key) {
            return entry.value;
        }

        while (entry.next !== null) {
            entry = entry.next;

            if (entry.key === key) {
                break;
            }
        }

        if (entry.key !== key) {
            return undefined;
        }

        return entry.value;
    }

    public remove(key :number) :void {
        const index = this.hash(key);

        if (this.buckets[index] === null) {
            ///throw new Error(`Key=${key} was not found`);
            return;
        }

        let entry = this.buckets[index]!;

        // first element only
        if (entry.key === key && entry.next === null) {
            this.buckets[index] = null;
            return;
        }

        // first element with chain
        if (entry.key === key) {
            this.buckets[index] = entry.next;
            return;
        }

        // traverse linked list
        while (entry.next !== null && entry.next.key !== key) {
            entry = entry.next;
        }

        if (entry.next === null) {
            //throw new Error(`Key=${key} was not found`);
            return;
        }

        entry.next = entry.next.next;
    }
}


function waysToPartition(nums: number[], k: number): number {
    const n = nums.length;

    // Create an array with the prefix sum for all nums 
    const prefix: number[] = new Array(n + 1).fill(0);

    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i]! + nums[i]!;
    }
    // It will produce something like:
    // nums   [22,4, -25, -20, -15, 15, -16,   7,  19,   -10, 0, -13, -14]
    // prefix [0, 22, 26,   1, -19, -34, -19, -35, -28,  -9, -19, -19, -32, -46]

    console.log("==s====")
    console.log(nums)
    console.log(prefix)
    console.log("==e====")
    
    const total = prefix[n]!;

    let ways = 0;
    if (total % 2 === 0) {
        // this is the magic, the left side needs to have exactly newTotal/2 size
        const half = total / 2;
        for (let j = 1; j < n; j++) {
            if (prefix[j] === half) ways++;
        }
    }

    const leftFreq = new MyMap();
    const rightFreq = new MyMap();

    // start in 1 and stopped before n to ensure the partition happens
    for (let j = 1; j < n; j++) {
        const p = prefix[j]!;
        // counting how many times the value appers on prefix array
        rightFreq.put(p, (rightFreq.get(p) ?? 0) + 1);
    }

    // simulating the k changes -  i is the block that is being changed
    for (let i = 0; i < n; i++) {
        const delta = k - nums[i]!;
        const newTotal = total + delta;

        if (newTotal % 2 === 0) {
            const t = newTotal / 2;

            const candidate =
                (leftFreq.get(t) ?? 0) + //try to in the "unchanged" values
                (rightFreq.get(t - delta) ?? 0); // try to find in the affected by K area

            ways = Math.max(ways, candidate);
        }

        const p = prefix[i + 1]!; //pivot

        leftFreq.put(p, (leftFreq.get(p) ?? 0) + 1);

        const rightCount = (rightFreq.get(p) ?? 0) - 1;
        if (rightCount <= 0) {
            rightFreq.remove(p);
        } else {
            rightFreq.put(p, rightCount);
        }
    }

    return ways;
}

export { waysToPartition };