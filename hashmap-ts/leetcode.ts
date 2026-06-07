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

        if (entry === null || entry === undefined) {
            return undefined;
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

    const prefix: number[] = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i]! + nums[i]!;
    }

    const total = prefix[n]!;

    let ans = 0;
    if (total % 2 === 0) {
        const half = total / 2;
        for (let j = 1; j < n; j++) {
            if (prefix[j] === half) ans++;
        }
    }

    const leftFreq = new MyMap();
    const rightFreq = new MyMap();

    for (let j = 1; j < n; j++) {
        const p = prefix[j]!;
        rightFreq.put(p, (rightFreq.get(p) ?? 0) + 1);
    }

    for (let i = 0; i < n; i++) {
        const d = k - nums[i]!;
        const newTotal = total + d;

        if (newTotal % 2 === 0) {
            const t = newTotal / 2;

            const candidate =
                (leftFreq.get(t) ?? 0) +
                (rightFreq.get(t - d) ?? 0);

            ans = Math.max(ans, candidate);
        }

        const p = prefix[i + 1]!;

        leftFreq.put(p, (leftFreq.get(p) ?? 0) + 1);

        const rc = (rightFreq.get(p) ?? 0) - 1;
        if (rc <= 0) {
            rightFreq.remove(p);
        } else {
            rightFreq.put(p, rc);
        }
    }

    return ans;
}

export { waysToPartition };