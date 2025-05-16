DO $$ 
BEGIN
   IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'ecommece') THEN
      CREATE DATABASE ecommece;
   END IF;
END $$;