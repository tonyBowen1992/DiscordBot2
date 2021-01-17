/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.dv8tion.jda.api.requests.RestAction;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

@Controller
@SpringBootApplication
public class Main extends ListenerAdapter{

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @Autowired
  private DataSource dataSource;

  int jasonCounter = 0;

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
    JDABuilder.createLight("Nzk2NTIxNTE3Mzk5NjcwODA0.X_ZIeA.5ftUJ06e-MsP57Oex6a0FmrH4sc", GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
            .addEventListeners(new Main())
            .build();
  }

  @Override
  public void onMessageReceived(MessageReceivedEvent event) {
    User author = event.getAuthor();
    Message msg = event.getMessage();
    String messageTest = msg.getContentRaw().toLowerCase();
    MessageChannel channel = event.getChannel();

    if (messageTest.contains("dick") && !(author.getName().equals("Mr. roBOT")) && !(messageTest.contains("findgif"))) {
      JDA JDA = channel.getJDA();
      OkHttpClient http = JDA.getHttpClient();
      EmbedBuilder result= new EmbedBuilder();

      okhttp3.Request request = new Request.Builder().url("http://tonybowen.me/dix.png").build();
      Response response = null;
      try {
        response = http.newCall(request).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        response = http.newCall(request).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        InputStream body = response.body().byteStream();
        result.setImage("attachment://image.png"); // Use same file name from attachment
        Response finalResponse = response;
        Response finalResponse1 = response;
        channel.sendMessage("Dick is no good. Dix is lvl99!") /* => RestAction<Message> */
                .queue();
        channel.sendMessage(result.build())
                .addFile(body, "image.png") // Specify file name as "image.png" for embed (this must be the same, its a reference which attachment belongs to which image in the embed)
                .queue(m -> finalResponse.close(), error -> { // Send message and close response when done
                  finalResponse1.close();
                  RestAction.getDefaultFailure().accept(error);
                });
      } catch (Throwable ex) {
        response.close();
        if (ex instanceof Error) throw (Error) ex;
        else throw (RuntimeException) ex;
      }
      response.body().close();
    }
    else if(messageTest.contains("findporn"))
    {
      JDA JDA = channel.getJDA();
      OkHttpClient http = JDA.getHttpClient();
      EmbedBuilder result= new EmbedBuilder();

      Integer searchValue = (int) (((Math.random()*(30000 - 1))) + 1);

      okhttp3.Request request = new Request.Builder().url("https://cdn.porngifs.com/img/" + searchValue).build();
      Response response = null;
      try {
        response = http.newCall(request).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        response = http.newCall(request).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        InputStream body = response.body().byteStream();
        result.setImage("attachment://image.gif"); // Use same file name from attachment
        Response finalResponse = response;
        Response finalResponse1 = response;
        channel.sendMessage(result.build())
                .addFile(body, "image.gif") // Specify file name as "image.png" for embed (this must be the same, its a reference which attachment belongs to which image in the embed)
                .queue(m -> finalResponse.close(), error -> { // Send message and close response when done
                  finalResponse1.close();
                  RestAction.getDefaultFailure().accept(error);
                });
      } catch (Throwable ex) {
        response.close();
        if (ex instanceof Error) throw (Error) ex;
        else throw (RuntimeException) ex;
      }
      response.body().close();
    }
    else if(messageTest.contains("fishing") && !(author.getName().equals("Mr. roBOT")))
    {
      JDA JDA = channel.getJDA();
      OkHttpClient http = JDA.getHttpClient();
      EmbedBuilder result= new EmbedBuilder();

      okhttp3.Request request = new Request.Builder().url("http://tonybowen.me/fishing.gif").build();
      Response response = null;
      try {
        response = http.newCall(request).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        response = http.newCall(request).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        InputStream body = response.body().byteStream();
        result.setImage("attachment://image.gif"); // Use same file name from attachment
        Response finalResponse = response;
        Response finalResponse1 = response;
        channel.sendMessage(result.build())
                .addFile(body, "image.gif") // Specify file name as "image.png" for embed (this must be the same, its a reference which attachment belongs to which image in the embed)
                .queue(m -> finalResponse.close(), error -> { // Send message and close response when done
                  finalResponse1.close();
                  RestAction.getDefaultFailure().accept(error);
                });
      } catch (Throwable ex) {
        response.close();
        if (ex instanceof Error) throw (Error) ex;
        else throw (RuntimeException) ex;
      }
      response.body().close();
    }
    else if (author.getName().equals("Carlos Pascetti")){
      if(jasonCounter < 5)
      {
        jasonCounter++;
        System.out.println("jc = " + jasonCounter);
      }
      else
      {
        channel.sendMessage("Have you eaten any vegetables today?") /* => RestAction<Message> */
                .queue();
        jasonCounter = 0;
      }
    }
    else if ((messageTest.contains("bursday") || messageTest.contains("birthday") )&& !(author.getName().equals("Mr. roBOT"))){
      JDA JDA = channel.getJDA();
      OkHttpClient http = JDA.getHttpClient();
      EmbedBuilder result= new EmbedBuilder();

      okhttp3.Request request = new Request.Builder().url("http://tonybowen.me/diobirthday.jpg").build();
      Response response = null;
      try {
        response = http.newCall(request).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        response = http.newCall(request).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        InputStream body = response.body().byteStream();
        result.setImage("attachment://image.jpg"); // Use same file name from attachment
        Response finalResponse = response;
        Response finalResponse1 = response;
        channel.sendMessage(result.build())
                .addFile(body, "image.jpg") // Specify file name as "image.png" for embed (this must be the same, its a reference which attachment belongs to which image in the embed)
                .queue(m -> finalResponse.close(), error -> { // Send message and close response when done
                  finalResponse1.close();
                  RestAction.getDefaultFailure().accept(error);
                });
      } catch (Throwable ex) {
        response.close();
        if (ex instanceof Error) throw (Error) ex;
        else throw (RuntimeException) ex;
      }
      response.body().close();

    }
  }

  @RequestMapping("/")
  String index() {
    return "index";
  }

  @RequestMapping("/db")
  String db(Map<String, Object> model) {
    try (Connection connection = dataSource.getConnection()) {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

      ArrayList<String> output = new ArrayList<String>();
      while (rs.next()) {
        output.add("Read from DB: " + rs.getTimestamp("tick"));
      }

      model.put("records", output);
      return "db";
    } catch (Exception e) {
      model.put("message", e.getMessage());
      return "error";
    }
  }

  @Bean
  public DataSource dataSource() throws SQLException {
    if (dbUrl == null || dbUrl.isEmpty()) {
      return new HikariDataSource();
    } else {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl(dbUrl);
      return new HikariDataSource(config);
    }
  }

}
