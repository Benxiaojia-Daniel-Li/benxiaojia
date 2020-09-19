package com.awesome.benxiaojia.controller.api;

import com.alibaba.druid.sql.visitor.functions.Char;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @Classname LeetCodeTest
 * @Description TODO
 * @Author by Daniel Li
 * @Contact 164278571@qq.com
 * @Date 2020/9/17
 */
@Slf4j
@RunWith(SpringRunner.class)
public class LeetCodeTest {
    @Test
    public void addTest(){
        List<Integer> list1 = new ArrayList<>();
//        list1.add(5);

        list1.add(9);
        list1.add(1);
        list1.add(6);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        ListNode l1 = list2ListNode(list1);
        ListNode l2 = list2ListNode(list2);
        ListNode l3 =this.addTwoNumbers(l1,l2);
        log.info("show",l3.toString());
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = traversalList(l1);
        List<Integer> list2 = traversalList(l2);
        List<Integer> listsum = new ArrayList<>();
        int remainder = 0;
//        int maxSize = list1.size()>=list2.size()?list1.size():list2.size();
        if(list1.size()<list2.size()){
            int size =list2.size()-list1.size();
            for(int i=0;i<size;i++){
                list1.add(0);
            }
        }
        if(list1.size()>list2.size()){
            int size =list1.size()-list2.size();
            for(int i=0;i<size;i++){
                list2.add(0);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            int sum = list1.get(i) + list2.get(i) + remainder;
            if (sum >= 10) {
                listsum.add(sum % 10);
                remainder = 1;
            } else {
                listsum.add(sum);
                remainder = 0;
            }
        }
        if(remainder>0){
            listsum.add(remainder);
        }
        ListNode ln = list2ListNode(listsum);
        return ln;
    }

    public List<Integer> traversalList(ListNode list){
        List<Integer> result = new ArrayList<>();
        if(null==list){
            return result;
        }
        result.add(list.val);
        List<Integer> child =traversalList(list.next);
        result.addAll(child);
        return result;
    }

    public ListNode list2ListNode(List<Integer> list){
        if (list ==null || list.size()==0){
            return null;

        }
        ListNode result = new ListNode(list.get(0));
        list.remove(list.get(0));
        result.next = list2ListNode(list);
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void testlengthOfLongestSubstring(){
        int a=lengthOfLongestSubstring("au");
        log.info("最大字符串长度{}",a);
    }

    public int lengthOfLongestSubstring(String s) {

        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        if(chars.length==0){
            return  0;
        }
        int size = 1;
        for (int i = 0; i < chars.length; i++) {
            if (!list.contains(String.valueOf(chars[i]))) {
                list.add(String.valueOf(chars[i]));
            }
            for (int j = i+1; j < chars.length; j++) {
                if (!list.contains(String.valueOf(chars[j]))) {
                    list.add(String.valueOf(chars[j]));
                } else {
                    size = list.size()>size? list.size():size;
                    list = new ArrayList<>();
                    break;
                }
                size = list.size()>size? list.size():size;
            }
        }
        return size;
    }
}
