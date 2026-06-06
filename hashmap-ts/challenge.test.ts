import { MyMap } from "./myMap";

describe("MyMap", () => {

    it("should create map with default capacity", () => {
        const map = new MyMap();

        expect(map).toBeDefined();
    });

    it("should create map with custom capacity", () => {
        const map = new MyMap(20);

        expect(map).toBeDefined();
    });

});

describe("put", () => {

    it("should store a value", () => {
        const map = new MyMap();

        map.put(1, 100);

        expect(map.get(1)).toBe(100);
    });

    it("should overwrite existing key", () => {
        const map = new MyMap();

        map.put(1, 100);
        map.put(1, 200);

        expect(map.get(1)).toBe(200);
    });

    it("should store multiple keys", () => {
        const map = new MyMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);

        expect(map.get(1)).toBe(100);
        expect(map.get(2)).toBe(200);
        expect(map.get(3)).toBe(300);
    });

});

describe("MyMap", () => {

    test("put", () => {
        const myMap = new MyMap();

        myMap.put(1, 100);
        myMap.put(20, 5);
        myMap.put(31, 6);
        myMap.put(41, 7);
        myMap.put(4, 19);

        expect(myMap.get(1)).toBe(100);
        expect(myMap.get(20)).toBe(5);
        expect(myMap.get(31)).toBe(6);
        expect(myMap.get(41)).toBe(7);
        expect(myMap.get(4)).toBe(19);
    });

    test("put should update existing key", () => {
        const myMap = new MyMap();

        myMap.put(20, 5);
        myMap.put(20, 6);

        expect(myMap.get(20)).toBe(6);
    });

    test("put should update existing key in collision chain", () => {
        const myMap = new MyMap();

        myMap.put(21, 5);
        myMap.put(31, 6);
        myMap.put(41, 6);
        myMap.put(51, 6);

        myMap.put(51, 888);

        expect(myMap.get(51)).toBe(888);
    });

    test("remove", () => {
        const myMap = new MyMap();

        myMap.put(1, 100);
        myMap.remove(1);

        expect(myMap.get(1)).toBe(-1);
    });

    test("remove from second bucket position", () => {
        const myMap = new MyMap();

        myMap.put(1, 100);
        myMap.put(11, 56);

        myMap.remove(11);

        expect(myMap.get(11)).toBe(-1);
    });

    test("remove from middle bucket position", () => {
        const myMap = new MyMap();

        myMap.put(1, 1);
        myMap.put(11, 2);
        myMap.put(21, 3);
        myMap.put(31, 4);

        myMap.remove(21);

        expect(myMap.get(11)).toBe(2);
        expect(myMap.get(31)).toBe(4);
    });

    test("leetcode test case", () => {
        const myMap = new MyMap();

        myMap.put(1, 1);
        myMap.put(2, 2);

        expect(myMap.get(1)).toBe(1);
        expect(myMap.get(3)).toBe(-1);

        myMap.put(2, 1);

        expect(myMap.get(2)).toBe(1);

        myMap.remove(2);

        expect(myMap.get(2)).toBe(-1);
    });

    test("should throw when removing non-existing key", () => {
        const myMap = new MyMap();

        expect(() => myMap.remove(999))
            .toThrow("Key=999 was not found");
    });

    test("should return -1 for non-existing key", () => {
        const myMap = new MyMap();

        expect(myMap.get(999)).toBe(-1);
    });

    test("should remove head of collision chain", () => {
        const myMap = new MyMap();

        myMap.put(1, 10);
        myMap.put(11, 20);
        myMap.put(21, 30);

        myMap.remove(1);

        expect(myMap.get(1)).toBe(-1);
        expect(myMap.get(11)).toBe(20);
        expect(myMap.get(21)).toBe(30);
    });

});