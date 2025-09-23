type Props = {
    title: string;
    price: number;
    quantity: number;
    imageUrl?: string;
};

export function ComponentCard({ title, price, quantity, imageUrl }: Props) {
    return (
        <article
            className="
        group rounded-2xl border border-transparent
        bg-[var(--card-bg)] text-[var(--card-text)]
        shadow-sm hover:shadow-lg hover:ring-2 hover:ring-[var(--card-hover-border)]
        transition p-4
      "
        >
            <div className="w-full aspect-[4/3] mb-3 overflow-hidden rounded-xl bg-black/10">
                {imageUrl ? (
                    <img
                        src={imageUrl}
                        alt={title}
                        className="w-full h-full object-cover"
                        loading="lazy"
                    />
                ) : (
                    <div className="w-full h-full grid place-items-center text-sm opacity-70">
                        No image
                    </div>
                )}
            </div>
            <h3 className="text-base font-semibold leading-snug">{title}</h3>
            <div className="flex items-center justify-between gap-2">
                <p>{price} PLN</p>
                <p className={quantity === 0 ? "text-red-500 font-semibold" : ""}>
                    {quantity === 0 ? "Sold out" : quantity}
                </p>
            </div>
        </article>
    );
}