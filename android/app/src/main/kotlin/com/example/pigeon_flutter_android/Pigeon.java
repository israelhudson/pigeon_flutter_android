// Autogenerated from Pigeon (v0.3.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package dev.flutter.pigeon;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class Pigeon {

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class SearchRequest {
    private String query;
    public String getQuery() { return query; }
    public void setQuery(String setterArg) { this.query = setterArg; }

    Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("query", query);
      return toMapResult;
    }
    static SearchRequest fromMap(Map<String, Object> map) {
      SearchRequest fromMapResult = new SearchRequest();
      Object query = map.get("query");
      fromMapResult.query = (String)query;
      return fromMapResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class SearchReply {
    private String result;
    public String getResult() { return result; }
    public void setResult(String setterArg) { this.result = setterArg; }

    Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("result", result);
      return toMapResult;
    }
    static SearchReply fromMap(Map<String, Object> map) {
      SearchReply fromMapResult = new SearchReply();
      Object result = map.get("result");
      fromMapResult.result = (String)result;
      return fromMapResult;
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter.*/
  public interface Api {
    SearchReply search(SearchRequest arg);

    /** Sets up an instance of `Api` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, Api api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.Api.search", new StandardMessageCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              @SuppressWarnings("ConstantConditions")
              SearchRequest input = SearchRequest.fromMap((Map<String, Object>)message);
              SearchReply output = api.search(input);
              wrapped.put("result", output.toMap());
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  private static Map<String, Object> wrapError(Throwable exception) {
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", exception.getClass().getSimpleName());
    errorMap.put("details", null);
    return errorMap;
  }
}
