"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.WomenList = void 0;
class WomenList {
    constructor() {
        this.storedWomen = [];
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
    getDescriptionOf(name) {
        const woman = this.getWoman(name);
        return woman.desc1 && woman.desc2 && woman.desc3 && woman.desc4 && woman.desc5;
    }
    getAllWomen() {
        return this.storedWomen.sort((woman1, woman2) => woman1.name.toLowerCase().localeCompare(woman2.name.toLowerCase()));
    }
    getTotalNumberOfWomen() {
        return this.storedWomen.length;
    }
}
exports.WomenList = WomenList;
//# sourceMappingURL=WomenList.js.map