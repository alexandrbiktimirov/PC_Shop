import type {CpuDto, CardItem} from "../components/Types.tsx";

async function http<T> (url: string): Promise<T> {
    const result = await fetch(url);
    if (!result.ok) {
        throw new Error(`HTTP ${result.status}`);
    }

    return result.json();
}

export async function fetchList(type:string): Promise<{id:number;brand:string;modelName:string;price:number;quantity:number;imageUrls:string[]}[]> {
    switch (type) {
        case "cpus":
            {
                const cpus:CpuDto[] = await http<CpuDto[]>("/api/v1/cpus");
                return cpus.map(c => ({
                    id: c.id,
                    brand: c.brand,
                    modelName: c.modelName,
                    price: c.price,
                    quantity: c.quantity,
                    imageUrls: c.imageUrls,
                }));
            }
        default:
            return [];
    }
}

export function toCardItem(raw: {id:number;brand:string;modelName:string;price:number;quantity:number;imageUrls:string[]}) : CardItem {
    return {
        id: raw.id,
        title: `${raw.brand} ${raw.modelName}`,
        price: raw.price,
        quantity: raw.quantity,
        imageUrl: raw.imageUrls[0],
    }
}