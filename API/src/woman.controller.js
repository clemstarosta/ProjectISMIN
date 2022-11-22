"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
exports.__esModule = true;
exports.WomanController = void 0;
var common_1 = require("@nestjs/common");
//Creation of the constructor
var WomanController = /** @class */ (function () {
    function WomanController(womanService) {
        this.womanService = womanService;
    }
    //provide all women
    WomanController.prototype.getAllWomen = function () {
        return this.womanService.getAllWomen();
    };
    //Adding a new woman to the API
    WomanController.prototype.createWoman = function (womanToCreate) {
        this.womanService.addWoman(womanToCreate);
        return this.womanService.getWoman(womanToCreate.name);
    };
    //Return a woman according to her name
    WomanController.prototype.getWomanByName = function (name) {
        return this.womanService.getWoman(name);
    };
    //Return a descrpition of a woman using her name
    WomanController.prototype.getWomanDescr = function (name) {
        return this.womanService.getDescriptionOf(name);
    };
    //Delete a woman by her name
    WomanController.prototype.deleteWoman = function (name) {
        return this.womanService.removeWoman(name);
    };
    __decorate([
        (0, common_1.Get)()
    ], WomanController.prototype, "getAllWomen");
    __decorate([
        (0, common_1.Post)(),
        __param(0, (0, common_1.Body)())
    ], WomanController.prototype, "createWoman");
    __decorate([
        (0, common_1.Get)(':name'),
        __param(0, (0, common_1.Param)('name'))
    ], WomanController.prototype, "getWomanByName");
    __decorate([
        (0, common_1.Get)(':name/desc'),
        __param(0, (0, common_1.Param)('name'))
    ], WomanController.prototype, "getWomanDescr");
    __decorate([
        (0, common_1.Delete)(':name'),
        __param(0, (0, common_1.Param)('name'))
    ], WomanController.prototype, "deleteWoman");
    WomanController = __decorate([
        (0, common_1.Controller)('women')
    ], WomanController);
    return WomanController;
}());
exports.WomanController = WomanController;
