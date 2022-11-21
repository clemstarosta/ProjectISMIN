<<<<<<< HEAD
import { IsNotEmpty, IsString } from 'class-validator';

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

  constructor(name: string, category: string, place: string, desc1: string, desc2: string, desc3: string, desc4: string, desc5: string) {
    this.name = name;
    this.category = category;
    this.place = place;
    this.desc1 = desc1;
    this.desc2 = desc2;
    this.desc3 = desc3;
    this.desc4 = desc4;
    this.desc5 = desc5;
  }
=======
import { IsNotEmpty, IsString } from 'class-validator';

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

  constructor(name: string, category: string, place: string, desc1: string, desc2: string, desc3: string, desc4: string, desc5: string) {
    this.name = name;
    this.category = category;
    this.place = place;
    this.desc1 = desc1;
    this.desc2 = desc2;
    this.desc3 = desc3;
    this.desc4 = desc4;
    this.desc5 = desc5;
  }
>>>>>>> 3c3a10b4f6e4738c522558416c642eb9528ef68a
}