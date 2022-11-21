<<<<<<< HEAD
import { Module } from '@nestjs/common';
import { WomanController } from './woman.controller';
import { WomanService } from './woman.service';
import { HttpModule } from '@nestjs/axios';

@Module({
  imports: [HttpModule],
  controllers: [WomanController],
  providers: [WomanService],
})
=======
import { Module } from '@nestjs/common';
import { WomanController } from './woman.controller';
import { WomanService } from './woman.service';
import { HttpModule } from '@nestjs/axios';

@Module({
  imports: [HttpModule],
  controllers: [WomanController],
  providers: [WomanService],
})
>>>>>>> 3c3a10b4f6e4738c522558416c642eb9528ef68a
export class WomanModule {}