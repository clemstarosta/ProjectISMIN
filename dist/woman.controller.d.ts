import { WomanService } from './woman.service';
import { Woman } from './Woman';
import { WomanDto } from './WomanDto';
export declare class WomanController {
    private readonly womanService;
    constructor(womanService: WomanService);
    getAllWomen(): Woman[];
    createWoman(womanToCreate: WomanDto): Woman;
    getWomanByName(name: string): Woman;
    getWomanDescr(name: string): String[];
    deleteWoman(name: string): void;
}
