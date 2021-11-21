import { Advertisement } from "./advertisement";

export interface ApplicationUpload {
    advertisementId: number;
    firstName: string;
    lastName: string;
    email: string;
    address: string;
    education: string;
    cvFile: Blob;
    letterFile: Blob;
    lat: number;
    lng: number;
}

export interface Application {
    id: number;
    advertisement: Advertisement;
    firstName: string;
    lastName: string;
    email: string;
    address: string;
    education: string;
    cvLocation: string;
    letterLocation: string;
}

export interface ApplicationSearch {
    query1: SimpleQuery,
    operation?: 'and' | 'or' | 'not',
    query2?: SimpleQuery,
}

export interface ApplicationGeoSearch{
    lat: number;
    lng: number;
    distance: number;
    unit: string;
}

export interface ApplicationSearchResult {
    firstName: string;
    lastName: string;
    education: string;
    letterText: string;
    adTitle: string;
    cvLocation: string;
    letterLocation: string;
}

interface SimpleQuery {
    field: 'firstName' | 'lastName' | 'education' | 'letterText',
    value: string
}