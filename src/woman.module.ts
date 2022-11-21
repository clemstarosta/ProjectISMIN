import { Module } from '@nestjs/common';
import { WomanController } from './woman.controller';
import { WomanService } from './woman.service';
import { HttpModule } from '@nestjs/axios';

@Module({
  imports: [HttpModule],
  controllers: [WomanController],
  providers: [WomanService],
})
export class WomanModule {}