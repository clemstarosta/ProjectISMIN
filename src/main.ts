<<<<<<< HEAD
import { NestFactory } from '@nestjs/core';
import { WomanModule } from './woman.module';
import { ValidationPipe } from '@nestjs/common';

//Ecoute sur le port 8080
const port = process.env.PORT || 8080;

async function bootstrap() {
  const app = await NestFactory.create(WomanModule);
  app.useGlobalPipes(new ValidationPipe());
  await app.listen(port);
}
=======
import { NestFactory } from '@nestjs/core';
import { WomanModule } from './woman.module';
import { ValidationPipe } from '@nestjs/common';

//Ecoute sur le port 8080
const port = process.env.PORT || 8080;

async function bootstrap() {
  const app = await NestFactory.create(WomanModule);
  app.useGlobalPipes(new ValidationPipe());
  await app.listen(port);
}
>>>>>>> 3c3a10b4f6e4738c522558416c642eb9528ef68a
bootstrap();