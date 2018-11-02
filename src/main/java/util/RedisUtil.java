package util;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
        @Bean
        RedisUtil util(RedisTemplate template){
            return new RedisUtil(template);
        }

        private RedisTemplate template;
        public RedisUtil(RedisTemplate template){
            this.template = template;
        }


        //value

        public boolean setValue(Object key, Object value){
            try{
                template.opsForValue().set(key, value);
                return true;
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }

        public Object getValue(Object key){
            return template.opsForValue().get(key);
        }

}
