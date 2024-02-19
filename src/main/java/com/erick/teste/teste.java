package com.erick.teste; // biblioteca do projeto

import com.erick.teste.Events.eventClass;
import io.github.cdimascio.dotenv.Dotenv; // carrega objetos do ambiente
import net.dv8tion.jda.api.OnlineStatus; // seta o status online com JDA
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder; // cria instancias shards para multiplas usabilidades
import net.dv8tion.jda.api.sharding.ShardManager; // instancia original para criação dos shards

public class teste {

    private ShardManager ShardM; // cria instancias para o shard manager
    private Dotenv venv; // variavel para as configurações de hambientes
    public teste(){
        venv = Dotenv.configure().load();
        DefaultShardManagerBuilder build = DefaultShardManagerBuilder.createDefault(getToken()); // cria shard com o token armazenado no arquivo env
        build.setStatus(OnlineStatus.ONLINE); // atribui o status "online"
        ShardM = build.build(); // finaliza a criação da instancia
        ShardM.addEventListener(new eventClass());
    }

    private String getToken(){
        return venv.get("TOKEN"); // pega token armazenado no arquivop .env
    }

    public ShardManager getSharM(){
        return ShardM; // devolve variavel privada shard
    }

    public static void main(String[] args){
        teste myBot = new teste(); // cria nova instancia para o servidor que requisitou
    }
}
