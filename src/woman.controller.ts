import {
  Body,
  Controller,
  Delete,
  HttpCode,
  Get,
  Param,
  Post,
  Query,
} from '@nestjs/common';
import { WomanService } from './woman.service';
import { Woman } from './Woman';
import { WomanDto } from './WomanDto';

//Creation of the constructor
@Controller('women')
export class WomanController {
  constructor(
    private readonly womanService: WomanService,
  ) {}

  //provide all women
  @Get()
  getAllWomen(): Woman[] {
    return this.womanService.getAllWomen();
  }

  //Adding a new woman to the API
  @Post()
  createWoman(@Body() womanToCreate: WomanDto): Woman {
    this.womanService.addWoman(womanToCreate);
    return this.womanService.getWoman(womanToCreate.name);
  }

  //Return a woman according to her name
  @Get(':name')
  getWomanByName(@Param('name') name: string): Woman {
    return this.womanService.getWoman(name);
  }

  //Return a descrpition of a woman using her name
  @Get(':name/desc')
  getWomanDescr(@Param('name') name: string): String[] {
    return this.womanService.getDescriptionOf(name);
  }

  //Delete a woman by her name
  @Delete(':name')
  deleteWoman(@Param('name') name: string): void {
    return this.womanService.removeWoman(name);
  }

}