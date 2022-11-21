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
bootstrap();