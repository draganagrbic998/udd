export interface ApplicationSearch {
    queries: SimpleQuery[]
    operator: 'and' | 'or'
}

export interface ApplicationGeoSearch {
    lat: number;
    lng: number;
    distance: number;
    unit: string;
}

export interface ApplicationSearchResult {
    adTitle: string;
    firstName: string;
    lastName: string;
    email: string;
    address: string;
    education: string;
    educationLevel: number;
    cvText: string;
    letterText: string;
    cvLocation: string;
    letterLocation: string;
}

export interface SimpleQuery {
    field: 'firstName' | 'lastName' | 'education' | 'educationLevel' | 'cvText' | 'letterText',
    value: string
    startValue: number
    endValue: number
}
