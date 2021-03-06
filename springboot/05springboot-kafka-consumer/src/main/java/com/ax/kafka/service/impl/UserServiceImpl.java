package com.ax.kafka.service.impl;

import com.ax.kafka.api.Topic;
import com.ax.kafka.api.UserService;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Properties;

@Service
public class UserServiceImpl implements UserService {

    private org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 初始化消息队列，发送之后暂时保存在list中，然后最早头部读取 earliest
     */
    private static final LinkedList<Long> linkedList = new LinkedList<>();
    private static String content = "";

    /**
     * groupId 不同, 同一个主题都能收到
     * groupId 相同,只能有一个收到主题消息
     * */
//    @KafkaListener(topics = {com.ax.kafka.api.Topic.SIMPLE})
//    public void consumer(ConsumerRecord<?,?> consumerRecord){
//        //判断是否为null
//        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
//
//        if(kafkaMessage.isPresent()){
//            //得到Optional实例中的值
//            Object message = kafkaMessage.get();
//            System.err.println("消费消息:"+message);
//        }
//    }


    //    @KafkaListener(groupId = "simpleGroup", topics = com.ax.kafka.api.Topic.SIMPLE)
//@KafkaListener( topics = com.ax.kafka.api.Topic.SIMPLE)
    @KafkaListener(groupId = "simpleGroup_1", topics = com.ax.kafka.api.Topic.SIMPLE)
    public void consumer1_1(ConsumerRecord<String, Object> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Consumer consumer, Acknowledgment ack) {

        System.out.println("=============消费者1-----1===========");
        System.out.println("消费者1--1 " + "consumer = " + consumer + "topic = " + topic + "value= " + record.value());


        Optional<Object> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
      /*      XyKafkaOutMsg build = new XyKafkaOutMsg();
            build.setGmtCreate(new Date());
            // TODO: 2019-05-15 此处fwBh就是消息队列的消息，后期使用修改
            build.setFwBh(System.currentTimeMillis());
            int insertOutMsg = xyKafkaOutMsgMapper.insertSelective(build);
            log.info("insertOutMsg result,{}",insertOutMsg==1 ? "成功" : "失败");
            linkedList.add(build.getId());*/
            ack.acknowledge(); // 手动提交消费消息
        }
        /*
         * 如果需要手工提交异步 consumer.commitSync();
         * 手工同步提交 consumer.commitAsync()
         */
    }


    @KafkaListener(groupId = "simpleGroup_2", topics = com.ax.kafka.api.Topic.SIMPLE)
    public void consumer1_2(ConsumerRecord<String, Object> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Consumer consumer, Acknowledgment ack) {

        System.out.println("=============消费者1----2===========");
        System.out.println("消费者1--2 " + "consumer = " + consumer + "topic = " + topic + "value= " + record.value());


        Optional<Object> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
      /*      XyKafkaOutMsg build = new XyKafkaOutMsg();
            build.setGmtCreate(new Date());
            // TODO: 2019-05-15 此处fwBh就是消息队列的消息，后期使用修改
            build.setFwBh(System.currentTimeMillis());
            int insertOutMsg = xyKafkaOutMsgMapper.insertSelective(build);
            log.info("insertOutMsg result,{}",insertOutMsg==1 ? "成功" : "失败");
            linkedList.add(build.getId());*/
            ack.acknowledge(); // 手动提交消费消息
        }
        /*
         * 如果需要手工提交异步 consumer.commitSync();
         * 手工同步提交 consumer.commitAsync()
         */
    }


    @Override
    public String getMsg() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.114:9092");
        props.put("group.id", "group1");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        //latest 最新  earliest 最早
        props.put("auto.offset.reset", "earliest");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(props);
        //指定订阅的topic
        kafkaConsumer.subscribe(Arrays.asList(Topic.SIMPLE));
        String content = "";
//        while (true) {
        log.info("nothing available...");
        ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(1000));
        for (ConsumerRecord<String, String> record : records) {
            log.info("获取消息详情，{}", record.value());
            content = record.value();
            if (content != "") {/*
                XyKafkaOutMsg build = new XyKafkaOutMsg();
                build.setGmtCreate(new Date());
                build.setFwBh(123L);
                int insertOutMsg = xyKafkaOutMsgMapper.insertSelective(build);
                log.info("insertOutMsg result,{}",insertOutMsg==1 ? "成功" : "失败");*/
                return content;
            }
        }
//        }
        return content;
    }

    @Override
    public synchronized String getMsg2() {
        /*log.info("队列消息list，{}",linkedList);
        while (true){
            if (CollectionUtils.isEmpty(linkedList)){
                log.info("任务队列为空");
                return null;
            }
//            XyKafkaOutMsg outMsg = xyKafkaOutMsgMapper.selectByPrimaryKey(linkedList.getFirst());
            if (outMsg==null){
                log.info("获取档案对象失败");
                //移除队列中数据
                log.info("队列移除的元素={}",linkedList.getFirst());
                linkedList.remove(linkedList.getFirst());
            }else if (RunStatus.SAY_NO.equals(outMsg.getDealFlag())){
                log.info("队列获取消息，总数={}，本条消息档案号={}",linkedList.size(),outMsg.getFwBh().toString());
                log.info("队列移除的元素={}",linkedList.getFirst());
                linkedList.remove(linkedList.getFirst());
                return outMsg.getFwBh().toString();
            }else if (RunStatus.SAY_YES.equals(outMsg.getDealFlag())){
                log.info("已经消费过");
                log.info("队列移除的元素={}",linkedList.getFirst());
                linkedList.remove(linkedList.getFirst());
            }
        }*/

        return null;
    }


    @Override
    public void resolve(Long fuBh) {
   /*     XyKafkaOutMsg outMsg =new  XyKafkaOutMsg();
        outMsg.setFwBh(fuBh);
        outMsg.setDealFlag(new Byte("1"));
        int updateStatus = xyKafkaOutMsgMapper.updateByFwBh(outMsg);
        log.info("insertOutMsg result,{}",updateStatus==1 ? "成功" : "失败");*/
    }

}
