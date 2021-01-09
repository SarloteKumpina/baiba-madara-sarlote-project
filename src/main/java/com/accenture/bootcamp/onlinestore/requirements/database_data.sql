insert into categories values
    (null, 'glasses', 'https://www.coolframes.co.uk/get_image_zoom.php?fid=165448&color=52_0UNN_Blue_Red_White_00_Demo_Lens&alt='),
    (null, 'dresses', 'https://i.pinimg.com/564x/78/d7/a6/78d7a68fdcf7e91560b82147e5025a96.jpg'),
    (null, 'shoes', 'https://cdn-images.farfetch-contents.com/13/68/25/52/13682552_21610419_1000.jpg'),
    (null, 'New Years offer', 'https://image.freepik.com/free-vector/lettering-happy-new-year-2021_52683-51730.jpg');

insert into products values
    (null, 'Tommy Hilfiger 1017', 120.00, 'Package contents: Tommy Hilfiger Eyeglasses, Tommy Hilfiger Genuine Case, Tommy Hilfiger Branded Cloth', 100, 'https://www.coolframes.co.uk/get_image_zoom.php?fid=165448&color=52_0UNN_Blue_Red_White_00_Demo_Lens&alt='),
    (null, 'Tommy Hilfiger 1234', 131.00, 'Package contents: Tommy Hilfiger Eyeglasses, Tommy Hilfiger Genuine Case, Tommy Hilfiger Branded Cloth', 100, 'https://www.coolframes.co.uk/get_image_zoom.php?fid=161978&color=52_01IL_Havana_Green_00_Demo_Lens&alt='),
    (null, 'Tommy Hilfiger 1319', 120.00, 'Package contents: Tommy Hilfiger Eyeglasses, Tommy Hilfiger Genuine Case, Tommy Hilfiger Branded Cloth', 100, 'https://www.coolframes.co.uk/get_image_zoom.php?fid=161990&color=53_0VKM_Black_Palladium_Petroleum_00_Demo_Lens&alt='),
    (null, 'Tommy Hilfiger Colorblock Stripe Crepe Sheath Dress', 51.99, 'Details: Colorblock stripes adorn a stretch crepe sheath dress for classic style.', 100, 'https://n.nordstrommedia.com/id/sr3/6bdd0cbe-b2c1-4a16-bf92-6fda04d23d30.jpeg?height=650&width=434'),
    (null, 'Tommy Hilfiger Mesh Lace Fit & Flare Dress', 99.99, 'Details:  A fit and flare dress offers mesh lace construction for a feminine style.', 100, 'https://n.nordstrommedia.com/id/sr3/7bd26d95-eab8-48e9-ad7f-9341c3ec05cf.jpeg?height=650&width=434'),
    (null, 'Tommy Hilfiger Essential Sleeveless Military Dress', 59.99, 'Details: Comfortable knit creates a military inspired dress with a contrasting spread collar and a flared skirt.', 100, 'https://n.nordstrommedia.com/id/sr3/674bd30b-e904-470b-a37d-79c2ae0f25bf.jpeg?height=650&width=434'),
    (null, 'Tommy Hilfiger Sleeveless Colorblock Shift Dress', 99.99, 'From floral maxis and nautical-striped sheaths to shirtdresses and LWDs we have found the best warm weather frocks of the season—all with wallet-friendly price tags.', 100, 'https://i.pinimg.com/564x/78/d7/a6/78d7a68fdcf7e91560b82147e5025a96.jpg'),
    (null, 'Tommy Hilfiger Inella (Black) Womens Shoes', 99.00, 'Man-made vegan leather Tommy Hilfiger® ankle boots in a round-toe silhouette with inside zipper and pull-tab at the heel.', 100, 'https://m.media-amazon.com/images/I/71EmUDbwGOL._SX400_.jpg'),
    (null, 'Tommy Hilfiger Divah Lace-up Booties ', 119.00, 'Tommy Hilfiger Divah Lace-Up Booties Womens Shoes', 100, 'https://cdn.modesens.com/product/4274063'),
    (null, 'Tommy Hilfiger Sunday dress sandals', 115.99, 'SUNDAY TWO-PIECE BLOCK-HEEL DRESS SANDALS WOMENs SHOES IN BLACK', 100, 'https://i.pinimg.com/564x/7d/2f/81/7d2f8138115daa40308983bdfb88eb2d.jpg'),
    (null, 'Tommy Hilfiger ankle strap sandals', 113.00, 'Blue calf leather ankle strap sandals from Tommy Hilfiger featuring an open toe, a buckle fastening, a branded insole and a chunky high heel.', 100, 'https://cdn-images.farfetch-contents.com/13/68/25/52/13682552_21610419_1000.jpg');

insert into products_categories values
    (null, 1, 1),
    (null, 2, 1),
    (null, 3, 1),
    (null, 4, 2),
    (null, 5, 2),
    (null, 6, 2),
    (null, 7, 2),
    (null, 8, 3),
    (null, 9, 3),
    (null, 10, 3),
    (null, 11, 3),
    (null, 1, 4),
    (null, 2, 4),
    (null, 3, 4),
    (null, 4, 4),
    (null, 5, 4),
    (null, 6, 4),
    (null, 7, 4),
    (null, 8, 4),
    (null, 9, 4),
    (null, 10, 4),
    (null, 11, 4);

insert into customers (first_name, last_name, phone_number, email, address) values
('Dace', 'Bogdāne', 26667203, 'dacebogdane@gmail.com', 'Madona, Vaboļu iela 11'),
('Linda', 'Gaiļuma', 28483901, 'lindagailuma@gmail.com', 'Rīga, Stabu iela 48'),
('Veronika', 'Krastiņa', 26322207, 'veronikakrastina@gmail.com', 'Liepāja, Bindes iela 9'),
('Brigita', 'Zaķe', 20078283, 'brigitazake@gmail.com', 'Rīga, Brīvības iela 125');

insert into orders (customer_id) values
(4),
(2),
(1),
(3);

insert into orders_products (product_id, quantity, order_id) values
(2, 1, 2),
(3, 1, 1),
(4, 1, 4),
(1, 1, 3);

insert into status (name) values
('PENDING'),
('APPROVED'),
('CANCELLED');
