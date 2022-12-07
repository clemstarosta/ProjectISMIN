import { Woman } from './Woman';
import { HttpService } from '@nestjs/axios/dist';
export declare class WomanService {
    private readonly httpService;
    private storedWomen;
    constructor(httpService: HttpService);
    onModuleInit(): Promise<void>;
    loadWomenFromAPI(): Promise<void>;
    addWoman(woman: Woman): void;
    getWoman(name: string): Woman;
    setWomanFavorite(name: string, fav: boolean): void;
    getDescriptionOf(name: string): string[];
    getAllWomen(): Woman[];
    getTotalNumberOfWomen(): number;
    removeWoman(name: string): void;
}
