"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.WomanService = void 0;
const common_1 = require("@nestjs/common");
const dist_1 = require("@nestjs/axios/dist");
const rxjs_1 = require("rxjs");
let WomanService = class WomanService {
    constructor(httpService) {
        this.httpService = httpService;
        this.storedWomen = [];
    }
    async onModuleInit() {
        await this.loadWomenFromAPI();
        await Promise.all([this.loadWomenFromAPI()]);
    }
    async loadWomenFromAPI() {
        this.httpService
            .get('https://api.npoint.io/ccf4c8c011a5d4b76b34')
            .pipe((0, rxjs_1.map)((resp) => resp.data), (0, rxjs_1.tap)((ApiWoman) => {
            ApiWoman.forEach(e => {
                return this.storedWomen.push({
                    lat: e.lat,
                    long: e.long,
                    name: e.name,
                    desc1: e.desc1,
                    desc2: e.desc2,
                    desc3: e.desc3,
                    desc4: e.desc4,
                    desc5: e.desc5,
                    place: e.place,
                    category: e.category,
                    thumb_url: e.thumb_url,
                    fav: false,
                });
            });
        }))
            .subscribe();
    }
    addWoman(woman) {
        if (!this.storedWomen.some((storedWomen) => woman.name === storedWomen.name)) {
            this.storedWomen.push(woman);
        }
    }
    getWoman(name) {
        const woman = this.storedWomen.find((woman) => woman.name === name);
        if (!woman) {
            throw new Error(`No woman with name ${name}`);
        }
        return woman;
    }
    setWomanFavorite(name, fav) {
        const woman = this.storedWomen.find((woman) => woman.name === name);
        this.storedWomen[woman.name].fav = fav;
    }
    getDescriptionOf(name) {
        const woman = this.getWoman(name);
        let desc = [woman.desc1, woman.desc2, woman.desc3, woman.desc4, woman.desc5];
        ;
        return desc;
    }
    getAllWomen() {
        return this.storedWomen.sort((woman1, woman2) => woman1.name.toLowerCase().localeCompare(woman2.name.toLowerCase()));
    }
    getTotalNumberOfWomen() {
        return this.storedWomen.length;
    }
    removeWoman(name) {
        this.storedWomen = this.storedWomen.filter((woman) => woman.name !== name);
    }
};
WomanService = __decorate([
    (0, common_1.Injectable)(),
    __metadata("design:paramtypes", [dist_1.HttpService])
], WomanService);
exports.WomanService = WomanService;
//# sourceMappingURL=woman.service.js.map