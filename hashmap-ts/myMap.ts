class Entry {
    constructor(
        public key :number,
        public value : number,
        public next: Entry | null = null
    ){}
}

export class MyMap {

    private capacity :number;
    private buckets: (Entry | null)[];

    constructor(capacity = 10){
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

        console.log("============>>>>  Collision Detected!!!")
        let entry = this.buckets[index]!;
        if(entry.key === key) {
            entry.value = value;
            return;
        }
        while (entry.next !== null) {
            if (entry.key === key) {
                console.log(`Already exists: updating value for key = ${key}`);
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        if (entry.key === key) {
            console.log(`Already exists: updating value for key = ${key}`);
            entry.value = value;
            return;
        }

        entry.next = new Entry(key, value);

    }

    public get(key :number): number {
        const index = this.hash(key);
        let entry = this.buckets[index];

        if (entry === null || entry === undefined) {
            return -1;
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
            return -1;
        }

        return entry.value;
    }

    public remove(key :number) :void {
        const index = this.hash(key);

        if (this.buckets[index] === null) {
            throw new Error(`Key=${key} was not found`);
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
            throw new Error(`Key=${key} was not found`);
        }

        entry.next = entry.next.next;
    }
}