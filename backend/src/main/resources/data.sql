INSERT INTO cpu (id, model_name, brand, price, quantity, socket_type, core_count, thread_count, tdp_watts) VALUES
(1, 'Ryzen 9 7950X',  'AMD',   599.00, 12, 'AM5',    16, 32, 170),
(2, 'Ryzen 7 7800X3D','AMD',   399.00, 20, 'AM5',     8, 16, 120),
(3, 'Ryzen 5 7600',   'AMD',   199.00, 35, 'AM5',     6, 12,  65),
(4, 'Ryzen 5 5600',   'AMD',   119.00, 40, 'AM4',     6, 12,  65),
(5, 'Ryzen 7 5700G',  'AMD',   189.00, 15, 'AM4',     8, 16,  65),
(6, 'Core i9-14900K', 'Intel', 589.00,  8, 'LGA1700',24, 32, 125),
(7, 'Core i5-14600K', 'Intel', 319.00, 16, 'LGA1700',14, 20, 125),
(8, 'Core i7-12700F', 'Intel', 249.00, 25, 'LGA1700',12, 20,  65),
(9, 'Core i3-14100',  'Intel', 139.00, 30, 'LGA1700', 4,  8,  60),
(10,'Core i5-12400',  'Intel', 189.00, 22, 'LGA1700', 6, 12,  65);

INSERT INTO cpu_images (cpu_id, image_url) VALUES
(1,  'https://www.amd.com/content/dam/amd/en/images/products/processors/ryzen/2505503-ryzen-9-7900x.jpg'),
(2,  'https://www.amd.com/content/dam/amd/en/images/products/processors/ryzen/2505503-ryzen-7-7800x3d.jpg'),
(3,  'https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2023/1/pr_2023_1_10_11_49_33_369_00.jpg'),
(4,  'https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2022/4/pr_2022_4_4_13_1_27_284_00.jpg'),
(5,  'https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2021/8/pr_2021_8_4_13_57_4_57_00.jpg'),
(6,  'https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2023/10/pr_2023_10_12_8_43_7_810_00.jpg'),
(7,  'https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2023/10/pr_2023_10_12_9_30_38_189_00.jpg'),
(8,  'https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2021/12/pr_2021_12_23_9_43_8_505_00.jpg'),
(9,  'https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2024/1/pr_2024_1_5_8_42_11_723_00.jpg'),
(10, 'https://cdn.x-kom.pl/i/setup/images/prod/big/product-new-big,,2021/12/pr_2021_12_23_9_30_34_58_00.jpg');

TRUNCATE cpu_images;
TRUNCATE cpu CASCADE;

INSERT INTO gpu (id, model_name, brand, price, quantity, memory_size_gb, tdp_watts, length_mm) VALUES
(1,  'GeForce RTX 4090',         'NVIDIA', 1599.00, 10, 24, 450, 336),
(2,  'GeForce RTX 4080 SUPER',   'NVIDIA',  999.00, 18, 16, 320, 310),
(3,  'GeForce RTX 4070 Ti SUPER','NVIDIA',  799.00, 20, 16, 285, 305),
(4,  'GeForce RTX 4070 SUPER',   'NVIDIA',  599.00, 28, 12, 220, 250),
(5,  'GeForce RTX 4060',         'NVIDIA',  299.00, 35,  8, 115, 242),
(6,  'Radeon RX 7900 XTX',       'AMD',     999.00, 12, 24, 355, 287),
(7,  'Radeon RX 7900 XT',        'AMD',     899.00, 15, 20, 315, 276),
(8,  'Radeon RX 7800 XT',        'AMD',     499.00, 25, 16, 263, 267),
(9,  'Radeon RX 7700 XT',        'AMD',     449.00, 22, 12, 245, 267),
(10, 'Arc A770 16GB',            'Intel',   329.00, 18, 16, 225, 280);

INSERT INTO gpu_images (gpu_id, image_url) VALUES
(1,  'https://upload.wikimedia.org/wikipedia/commons/7/76/Asus_Strix_RTX_4090.jpg'),
(2,  'https://upload.wikimedia.org/wikipedia/commons/7/76/Asus_Strix_RTX_4090.jpg'),
(3,  'https://upload.wikimedia.org/wikipedia/commons/7/76/Asus_Strix_RTX_4090.jpg'),
(4,  'https://upload.wikimedia.org/wikipedia/commons/7/76/Asus_Strix_RTX_4090.jpg'),
(5,  'https://upload.wikimedia.org/wikipedia/commons/7/76/Asus_Strix_RTX_4090.jpg'),
(6,  'https://upload.wikimedia.org/wikipedia/commons/a/a8/Sapphire_AMD_Radeon_RX_7900_XTX.jpg'),
(7,  'https://upload.wikimedia.org/wikipedia/commons/a/a8/Sapphire_AMD_Radeon_RX_7900_XTX.jpg'),
(8,  'https://upload.wikimedia.org/wikipedia/commons/a/a8/Sapphire_AMD_Radeon_RX_7900_XTX.jpg'),
(9,  'https://upload.wikimedia.org/wikipedia/commons/a/a8/Sapphire_AMD_Radeon_RX_7900_XTX.jpg'),
(10, 'https://upload.wikimedia.org/wikipedia/commons/a/a8/Sapphire_AMD_Radeon_RX_7900_XTX.jpg');