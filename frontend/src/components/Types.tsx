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

export type CardItem = {
    id: number;
    title: string;
    imageUrl?: string;
}