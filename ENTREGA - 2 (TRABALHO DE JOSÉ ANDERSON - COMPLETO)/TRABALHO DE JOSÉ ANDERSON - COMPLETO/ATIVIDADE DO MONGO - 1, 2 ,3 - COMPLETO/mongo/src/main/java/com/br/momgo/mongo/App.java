package com.br.momgo.mongo;

import model.produto;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientoptions;
import com.mongodb.client.MongoCollection;
import com.mongo.client.MongoDatabase;
import org.bson.document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.pojocodecProvider;

import java.util.fuction.consumer;

import static com.mongodb.client.model.updates.set;
import static org.bson.codecs.configuration.codecRegistries.fromProviders;
import static org.bson.codecs.configuration.codecRegistries.fromRegistries;

public class App 
{
    public static void main( String[] args )
    {
    	CodecRegistry pojoCodecRegistry - fromRegistries (MongoClient.getDefaultCodecRegistry()
    			fromProviders (PojoCodecProvider.builder().automatic(true).build()));
    	
    	
    			MongoClient mongoClient = new MongoClient ("localhost:27017"
    			MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
    			
    			
    			MongoDatabase database = mongoClient .getDatabase( "exemplo")
    			.withodecRegistry(pojoCodecRegistry);
    			
    			MongoCollection<Produto> collection
    			database.getCollection("Produto", Produto.class);
    }
}
