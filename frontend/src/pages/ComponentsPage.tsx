import React, { useEffect, useState } from "react";
import {Link, useParams} from "react-router-dom";
import { fetchList, toCardItem } from "../services/catalog";
import type { CardItem } from "../components/Types.tsx";
import { ComponentCard } from "../components/ComponentCard";

export const ComponentsPage: React.FC = () => {
    const { type = "cpus" } = useParams();
    const [items, setItems] = useState<CardItem[]>([]);
    const [loading, setLoading] = useState(true);
    const [err, setErr] = useState<string | null>(null);

    useEffect(() => {
        let alive = true;
        setLoading(true);
        setErr(null);

        fetchList(type)
            .then(list => {
                if (alive) setItems(list.map(toCardItem));
            })
            .catch(e => {
                if (alive) setErr(e.message);
            })
            .finally(() => {
                if (alive) setLoading(false);
            });

        return () => {
            alive = false;
        };
    }, [type]);

    return (
        <div className="px-4 py-6">
            {loading && <p className="info">Loading {type}…</p>}
            {err && <p role="alert" className="info">Error: {err}</p>}
            {!loading && !err && items.length === 0 && <p className="info">No items.</p>}

            <div className="grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-4 gap-4">
                {items.map(i =>
                    <Link to={`/components/${type}/${i.id}`}>
                        <ComponentCard key={i.id} title={i.title} price={i.price} quantity={i.quantity} imageUrl={i.imageUrl} />
                    </Link>
                )}
            </div>
        </div>
    );
};