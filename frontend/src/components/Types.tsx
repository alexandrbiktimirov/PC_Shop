export type CpuDto = {
    id: number;
    brand: string;
    modelName: string;
    price: number;
    quantity: number;
    imageUrls: string[];
    socketType: string;
    coreCount: number;
    threadCount: number;
    tdpWatts: number;
}

export type GpuDto = {
    id: number;
    brand: string;
    modelName: string;
    price: number;
    quantity: number;
    imageUrls: string[];
    memorySizeGb: number;
    tdpWatts: number;
    lengthMm: number;
}

export type CardItem = {
    id: number;
    title: string;
    price: number;
    quantity: number;
    imageUrl?: string;
}
