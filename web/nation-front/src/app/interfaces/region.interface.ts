import { Country } from "./country.interface";

export interface Region {
    regionId: number;
    name: string;
    continent: Continent;
    countries: Country[];
  }

  export interface Continent {
    continentId: number;
    name: string;
  }