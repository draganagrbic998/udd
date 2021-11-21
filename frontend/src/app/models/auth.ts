export interface Auth {
    email: string;
    password: string;
    role: Role;
    token: string;
}

export enum Role {
    KANDIDAT = 'kandidat',
    TEHNICKO_LICE = 'tehnicko lice',
    HR_LICE = 'hr lice',
    ZAPOSLENI_U_SLUZBI_NABAVKE = 'zaposleni u sluzbi nabavke',
    DOBAVLJAC = 'dobavljac'
}