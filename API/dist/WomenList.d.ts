import { Woman } from './Woman';
export declare class WomenList {
    private storedWomen;
    addWoman(woman: Woman): void;
    getWoman(name: string): Woman;
    getDescriptionOf(name: string): string;
    getAllWomen(): Woman[];
    getTotalNumberOfWomen(): number;
}
