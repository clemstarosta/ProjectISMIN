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
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.WomanController = void 0;
const common_1 = require("@nestjs/common");
const woman_service_1 = require("./woman.service");
const WomanDto_1 = require("./WomanDto");
let WomanController = class WomanController {
    constructor(womanService) {
        this.womanService = womanService;
    }
    getAllWomen() {
        return this.womanService.getAllWomen();
    }
    createWoman(womanToCreate) {
        this.womanService.addWoman(womanToCreate);
        return this.womanService.getWoman(womanToCreate.name);
    }
    getWomanByName(name) {
        return this.womanService.getWoman(name);
    }
    getWomanDescr(name) {
        return this.womanService.getDescriptionOf(name);
    }
    setFavoriteStation(name, fav) {
        this.womanService.setWomanFavorite(name, fav);
        return this.womanService.getWoman(name);
    }
    deleteWoman(name) {
        return this.womanService.removeWoman(name);
    }
};
__decorate([
    (0, common_1.Get)(),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", []),
    __metadata("design:returntype", Array)
], WomanController.prototype, "getAllWomen", null);
__decorate([
    (0, common_1.Post)(),
    __param(0, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [WomanDto_1.WomanDto]),
    __metadata("design:returntype", Object)
], WomanController.prototype, "createWoman", null);
__decorate([
    (0, common_1.Get)(':name'),
    __param(0, (0, common_1.Param)('name')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", Object)
], WomanController.prototype, "getWomanByName", null);
__decorate([
    (0, common_1.Get)(':name/desc'),
    __param(0, (0, common_1.Param)('name')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", Array)
], WomanController.prototype, "getWomanDescr", null);
__decorate([
    (0, common_1.Put)(':name'),
    __param(0, (0, common_1.Param)('name')),
    __param(1, (0, common_1.Body)()),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String, Boolean]),
    __metadata("design:returntype", Object)
], WomanController.prototype, "setFavoriteStation", null);
__decorate([
    (0, common_1.Delete)(':name'),
    __param(0, (0, common_1.Param)('name')),
    __metadata("design:type", Function),
    __metadata("design:paramtypes", [String]),
    __metadata("design:returntype", void 0)
], WomanController.prototype, "deleteWoman", null);
WomanController = __decorate([
    (0, common_1.Controller)('women'),
    __metadata("design:paramtypes", [woman_service_1.WomanService])
], WomanController);
exports.WomanController = WomanController;
//# sourceMappingURL=woman.controller.js.map