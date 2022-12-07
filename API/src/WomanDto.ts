import { IsNotEmpty, IsString, IsNumber } from 'class-validator';

export class WomanDto {
  @IsNotEmpty()
  @IsString()
  readonly name: string;

  @IsNotEmpty()
  @IsString()
  readonly category: string;

  @IsNotEmpty()
  @IsString()
  readonly place: string;

  @IsNotEmpty()
  @IsString()
  readonly desc1: string;

  @IsNotEmpty()
  @IsString()
  readonly desc2: string;

  @IsNotEmpty()
  @IsString()
  readonly desc3: string;

  @IsNotEmpty()
  @IsString()
  readonly desc4: string;

  @IsNotEmpty()
  @IsString()
  readonly desc5: string;

  @IsNotEmpty()
  @IsNumber()
  readonly long: number;

  @IsNotEmpty()
  @IsNumber()
  readonly lat: number;

  @IsNotEmpty()
  @IsString()
  readonly thumb_url : string;

  fav: boolean;


  constructor(name: string, category: string, place: string, desc1: string, desc2: string, desc3: string, desc4: string, desc5: string, 
    long: number, lat: number, thumb_url: string) {
    this.name = name;
    this.category = category;
    this.place = place;
    this.desc1 = desc1;
    this.desc2 = desc2;
    this.desc3 = desc3;
    this.desc4 = desc4;
    this.desc5 = desc5;
    this.long=long;
    this.lat=lat;
    this.thumb_url = thumb_url;
    this.fav = false;
  }
}