"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const core_1 = require("@nestjs/core");
const woman_module_1 = require("./woman.module");
const common_1 = require("@nestjs/common");
const port = process.env.PORT || 8080;
async function bootstrap() {
    const app = await core_1.NestFactory.create(woman_module_1.WomanModule);
    app.useGlobalPipes(new common_1.ValidationPipe());
    await app.listen(port);
}
bootstrap();
//# sourceMappingURL=main.js.map