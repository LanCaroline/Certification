INSERT INTO questions (id, description, technology) VALUES
('0186392b-03ca-4075-8674-3974f156f48b', 'Como criar uma classe em Java?', 'JAVA'),
('55617a4d-0b71-4145-96f5-34ba6b978b73', 'Explique o conceito de polimorfismo em Java.', 'JAVA'),
('ea191c03-c47e-4e31-b6fc-9dd927c258fb', 'Como lidar com as exceções em Java?', 'JAVA');

INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('6f13ca99-e63d-40fa-8d17-846c29f6639e', '0186392b-03ca-4075-8674-3974f156f48b', true, 'Usando a palavra-chave "class"'),
('82641f4e-3227-4c78-83dc-87cdcd5fdc55', '0186392b-03ca-4075-8674-3974f156f48b', false, 'Definindo um interface em Java'),
('9b5b35df-695f-4cdd-8b4e-73cf262158c1', '0186392b-03ca-4075-8674-3974f156f48b', false, 'Utilizando métodos estáticos'),
('2c09a0bf-5a0a-43bd-bacd-de78b2f7035e', '0186392b-03ca-4075-8674-3974f156f48b', false, 'Criando um construtor padrão');

INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('b9d11269-3dd8-41ea-bcc4-e4f2c8de473b', '55617a4d-0b71-4145-96f5-34ba6b978b73', false, 'Herança simples'),
('bb97656e-94d4-4442-b236-d75def635466', '55617a4d-0b71-4145-96f5-34ba6b978b73', false, 'Encapsulamento em Java'),
('351c9c48-2c55-4579-b276-9e89b48b0895', '55617a4d-0b71-4145-96f5-34ba6b978b73', false, 'Sobrecarga de métodos'),
('ccb03cc8-2b6a-4ae0-bdd1-53797e67f63e', '55617a4d-0b71-4145-96f5-34ba6b978b73', true, 'Capacidade de um objeto de assumir várias formas');

INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('1e4d53fe-3180-4b69-9be3-ae561f05fca5', 'ea191c03-c47e-4e31-b6fc-9dd927c258fb', false, 'Ignorando a exceção'),
('24d723c5-16c0-4ab1-85b6-86eac3b805d0', 'ea191c03-c47e-4e31-b6fc-9dd927c258fb', true, 'Utilizando blocos try-catch'),
('2e0f0eb2-02b6-452f-a1db-e34a1fcfe32e', 'ea191c03-c47e-4e31-b6fc-9dd927c258fb', false, 'Declarando um exceção sem tratamento'),
('a9c2bcaa-b616-4838-9896-99e162cbb80d', 'ea191c03-c47e-4e31-b6fc-9dd927c258fb', false, 'Usando a palavra-chave "finally"');


