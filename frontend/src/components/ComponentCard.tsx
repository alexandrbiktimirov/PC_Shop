type Props = {
    title: string;
    imageUrl?: string;
};

export function ComponentCard({ title, imageUrl }: Props) {
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
        </article>
    );
}