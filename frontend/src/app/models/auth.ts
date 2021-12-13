export interface Auth {
    email: string;
    password: string;
    role: RoleAuth;
    token: string;
}

export enum RoleAuth {
    KANDIDAT = 'kandidat',
    TEHNICKO_LICE = 'tehnicko lice',
    HR_LICE = 'hr lice',
    ZAPOSLENI_U_SLUZBI_NABAVKE = 'zaposleni u sluzbi nabavke',
    DOBAVLJAC = 'dobavljac'
}