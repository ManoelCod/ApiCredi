DO $$ 
BEGIN
   -- Verifica se o banco existe e cria se não existir
   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ecommece') THEN
      CREATE DATABASE ecommece;
   END IF;

   -- Criar a tabela se não existir
   IF NOT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'credito') THEN
      CREATE TABLE credito (
         numero_credito VARCHAR(20),
         numero_nfse VARCHAR(20),
         data_constituicao DATE,
         valor_issqn NUMERIC(10,2),
         tipo_credito VARCHAR(50),
         simples_nacional BOOLEAN,
         aliquota NUMERIC(5,2),
         valor_faturado NUMERIC(12,2),
         valor_deducao NUMERIC(12,2),
         base_calculo NUMERIC(12,2)
      );

      -- Inserir dados na tabela após a criação
      INSERT INTO credito (numero_credito, numero_nfse, data_constituicao, valor_issqn, 
         tipo_credito, simples_nacional, aliquota, valor_faturado, valor_deducao, base_calculo)
      VALUES 
         ('123456', '7891011', '2024-02-25', 1500.75, 'ISSQN', true, 5.0, 30000.00, 5000.00, 25000.00),
         ('789012', '7891011', '2024-02-26', 1200.50, 'ISSQN', false, 4.5, 25000.00, 4000.00, 21000.00),
         ('654321', '1122334', '2024-01-15', 800.50, 'Outros', true, 3.5, 20000.00, 3000.00, 17000.00);
   END IF;
END $$;