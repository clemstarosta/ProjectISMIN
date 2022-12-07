import { Injectable } from '@nestjs/common';
import { Woman } from './Woman';
import { readFile } from 'fs/promises';
import { HttpService } from '@nestjs/axios/dist';
import { map, tap } from 'rxjs';
import { ApiWoman } from './ApiWoman';

@Injectable()
export class WomanService {
    private storedWomen: Woman[] = [];

    //Création du constructeur
    constructor(private readonly httpService: HttpService) {}

    async onModuleInit():Promise<void>{
      await this.loadWomenFromAPI();
      
      await Promise.all([ this.loadWomenFromAPI()]);
    }
    
    //Loads all women from the API
    async loadWomenFromAPI(): Promise<void>{
      this.httpService
      .get<ApiWoman[]>('https://api.npoint.io/ccf4c8c011a5d4b76b34')
      .pipe(
        map((resp)=> resp.data),
        tap((ApiWoman) => {
          ApiWoman.forEach(e=> {
            return this.storedWomen.push({
              lat: e.lat,
              long : e.long,
              name: e.name,
              desc1: e.desc1,
              desc2: e.desc2,
              desc3: e.desc3,
              desc4: e.desc4,
              desc5: e.desc5,
              place: e.place,
              category: e.category,
              thumb_url: e.thumb_url,
              fav: false,
            });
          });
        }),
      )
      .subscribe();
  }

    //Ajout d'une femme
    addWoman(woman: Woman): void {
      if (!this.storedWomen.some((storedWomen) => woman.name === storedWomen.name)) {
        this.storedWomen.push(woman);
      }
    }
  
    //Récupération d'une femme à l'aide de son nom
    getWoman(name: string): Woman {
      const woman = this.storedWomen.find((woman) => woman.name === name);
      if (!woman) {
        throw new Error(`No woman with name ${name}`);
      }
      return woman;
    }

    setWomanFavorite(name: string, fav: boolean) {
      const nam = this.storedWomen.find((woman) => woman.name === name);
      if (nam == null) {
        return null
      }
      this.storedWomen[name].fav =fav;
    }
  
    //Renvoie toutes les descriptions d'une femme à l'aide de son nom
    getDescriptionOf(name: string): string[] {
      const woman = this.getWoman(name)
      let desc: string[]= [ woman.desc1, woman.desc2, woman.desc3, woman.desc4, woman.desc5];;

      return desc;
    }
  
    //Renvoie toutes les femmes de la bdd
    getAllWomen(): Woman[] {
      return this.storedWomen.sort((woman1, woman2) =>
        woman1.name.toLowerCase().localeCompare(woman2.name.toLowerCase()),
      );
    }
  
    //Renvoie le nombre total de femme de la bdd
    getTotalNumberOfWomen(): number {
      return this.storedWomen.length;
    }

    //Supprime une femme de la bdd
    removeWoman(name: string) {
        this.storedWomen = this.storedWomen.filter((woman) => woman.name !== name);
      }
  
}