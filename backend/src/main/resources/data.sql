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
(1,  'https://www.amd.com/en/products/processors/desktops/ryzen/7000-series/amd-ryzen-9-7950x.html'),
(2,  'https://www.amd.com/en/products/processors/desktops/ryzen/7000-series/amd-ryzen-7-7800x3d.html'),
(3,  'https://www.amd.com/en/products/processors/desktops/ryzen/7000-series/amd-ryzen-5-7600.html'),
(4,  'https://www.amd.com/en/support/downloads/drivers.html/processors/ryzen/ryzen-5000-series/amd-ryzen-5-5600.html'),
(5,  'https://www.amd.com/en/support/downloads/drivers.html/processors/ryzen/ryzen-5000-series/amd-ryzen-7-5700g.html'),
(6,  'https://www.intel.com/content/www/us/en/products/sku/236773/intel-core-i9-processor-14900k-36m-cache-up-to-6-00-ghz/specifications.html'),
(7,  'https://www.intel.com/content/www/us/en/products/sku/236799/intel-core-i5-processor-14600k-24m-cache-up-to-5-30-ghz/specifications.html'),
(8,  'https://www.intel.com/content/www/us/en/products/sku/134592/intel-core-i712700f-processor-25m-cache-up-to-4-90-ghz/specifications.html'),
(9,  'https://www.intel.com/content/www/us/en/products/sku/236774/intel-core-i3-processor-14100-12m-cache-up-to-4-70-ghz/specifications.html'),
(10, 'https://www.intel.com/content/www/us/en/products/sku/134586/intel-core-i5-12400-processor-18m-cache-up-to-4-40-ghz/specifications.html');