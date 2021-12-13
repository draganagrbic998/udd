import { Advertisement } from "./advertisement";

export interface ApplicationUpload {
    advertisementId: number;
    firstName: string;
    lastName: string;
    education: string;
    educationLevel: number;
    cvFile: Blob;
    letterFile: Blob;
    lat: number;
    lng: number;
    email: string;
    address: string;
}

export interface Application {
    id: number;
    advertisement: Advertisement;
    firstName: string;
    lastName: string;
    education: string;
    educationLevel: number;
    cvLocation: string;
    letterLocation: string;
    email: string;
    address: string;
}

export interface ApplicationSearch {
    query1: SimpleQuery,
    operation?: 'and' | 'or' | 'not',
    query2?: SimpleQuery,
}

export interface ApplicationGeoSearch {
    lat: number;
    lng: number;
    distance: number;
    unit: string;
}

export interface ApplicationSearchResult {
    firstName: string;
    lastName: string;
    education: string;
    educationLevel: string;
    cvText: string;
    letterText: string;
    cvLocation: string;
    letterLocation: string;
    adTitle: string;
}

interface SimpleQuery {
    field: 'firstName' | 'lastName' | 'education' | 'educationLevel' | 'cvText' | 'letterText',
    value: string
}