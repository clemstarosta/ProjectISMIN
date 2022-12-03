"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
exports.__esModule = true;
exports.WomanService = void 0;
var common_1 = require("@nestjs/common");
var rxjs_1 = require("rxjs");
var WomanService = /** @class */ (function () {
    //Création du constructeur
    function WomanService(httpService) {
        this.httpService = httpService;
        this.storedWomen = [];
    }
    WomanService.prototype.onModuleInit = function () {
        return __awaiter(this, void 0, void 0, function () {
            return __generator(this, function (_a) {
                switch (_a.label) {
                    case 0: return [4 /*yield*/, this.loadWomenFromAPI()];
                    case 1:
                        _a.sent();
                        return [4 /*yield*/, Promise.all([this.loadWomenFromAPI()])];
                    case 2:
                        _a.sent();
                        return [2 /*return*/];
                }
            });
        });
    };
    //Loads all women from the API
    WomanService.prototype.loadWomenFromAPI = function () {
        return __awaiter(this, void 0, void 0, function () {
            var _this = this;
            return __generator(this, function (_a) {
                this.httpService
                    .get('https://api.npoint.io/ccf4c8c011a5d4b76b34')
                    .pipe((0, rxjs_1.map)(function (resp) { return resp.data; }), (0, rxjs_1.tap)(function (ApiWoman) {
                    ApiWoman.forEach(function (e) {
                        return _this.storedWomen.push({
                            name: e.name,
                            desc1: e.desc1,
                            desc2: e.desc2,
                            desc3: e.desc3,
                            desc4: e.desc4,
                            desc5: e.desc5,
                            place: e.place,
                            category: e.category,
                            long: e.long,
                            lat: e.lat,
                            thumb_url: e.thumb_url
                        });
                    });
                }))
                    .subscribe();
                return [2 /*return*/];
            });
        });
    };
    //Ajout d'une femme
    WomanService.prototype.addWoman = function (woman) {
        if (!this.storedWomen.some(function (storedWomen) { return woman.name === storedWomen.name; })) {
            this.storedWomen.push(woman);
        }
    };
    //Récupération d'une femme à l'aide de son nom
    WomanService.prototype.getWoman = function (name) {
        var woman = this.storedWomen.find(function (woman) { return woman.name === name; });
        if (!woman) {
            throw new Error("No woman with name ".concat(name));
        }
        return woman;
    };
    //Renvoie toutes les descriptions d'une femme à l'aide de son nom
    WomanService.prototype.getDescriptionOf = function (name) {
        var woman = this.getWoman(name);
        var desc = [woman.desc1, woman.desc2, woman.desc3, woman.desc4, woman.desc5];
        ;
        return desc;
    };
    //Renvoie toutes les femmes de la bdd
    WomanService.prototype.getAllWomen = function () {
        return this.storedWomen.sort(function (woman1, woman2) {
            return woman1.name.toLowerCase().localeCompare(woman2.name.toLowerCase());
        });
    };
    //Renvoie le nombre total de femme de la bdd
    WomanService.prototype.getTotalNumberOfWomen = function () {
        return this.storedWomen.length;
    };
    //Supprime une femme de la bdd
    WomanService.prototype.removeWoman = function (name) {
        this.storedWomen = this.storedWomen.filter(function (woman) { return woman.name !== name; });
    };
    WomanService = __decorate([
        (0, common_1.Injectable)()
    ], WomanService);
    return WomanService;
}());
exports.WomanService = WomanService;
