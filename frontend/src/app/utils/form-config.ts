export interface FormConfig {
    [control: string]: {
        type?: 'text' | 'password' | 'file' | 'location',
        validation: 'none' | 'required'
    }
}
