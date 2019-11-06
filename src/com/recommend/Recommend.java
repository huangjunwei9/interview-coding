package com.recommend;

/**
 * @Author �ƾ���
 * @create 2019/8/31 21:57
 * @email hjunwei@foxmail.com
 */
import java.util.*;

public class Recommend {

    public Recommend() {
    }

    /**
     * �ڸ���username������£����������û������ľ��벢����
     * @param username  Ŀ���û�������
     * @param userSet   Ŀ���û����ھ�
     * @return Ŀ���û��������ھӼ�ľ���
     */
    private Map<Double, String> computeNearestNeighbor(String username, UserSet userSet) {
        Map<Double, String> distancesTreeMap = new TreeMap<>();

        UserSet.User u1 = userSet.getUserByUsername(username);
        for (int i = 0; i < userSet.userArrayList.size(); i++) { //
            UserSet.User u2 = userSet.getUserByPosition(i);

            //����Ŀ���û����ھ�֮��ľ��루��ô�������룿�������Ѿ��뱣������
            if (!u2.userRealName.equals(username)) {
                double distance = pearson_dis(u2.movieArrayList, u1.movieArrayList);
                distancesTreeMap.put(distance, u2.userRealName);
            }

        }
        System.out.println("distance => " + distancesTreeMap);
        return distancesTreeMap;
    }


    /**
     * ����2��������м��person����
     *
     * @param rating1
     * @param rating2
     * @return
     */
    private double pearson_dis(List<UserSet.Movie> rating1, List<UserSet.Movie> rating2) {
        int sum_xy = 0;
        int sum_x = 0;
        int sum_y = 0;
        double sum_x2 = 0;
        double sum_y2 = 0;
        int n = 0;
        for (int i = 0; i < rating1.size(); i++) {
            UserSet.Movie key1 = rating1.get(i);
            for (int j = 0; j < rating2.size(); j++) {
                UserSet.Movie key2 = rating2.get(j);
                if (key1.movieName.equals(key2.movieName)) {
                    n += 1;
                    int x = key1.movieScore;
                    int y = key2.movieScore;
                    sum_xy += x * y;
                    sum_x += x;
                    sum_y += y;
                    sum_x2 += Math.pow(x, 2);
                    sum_y2 += Math.pow(y, 2);
                }

            }
        }
        double denominator = Math.sqrt(sum_x2 - Math.pow(sum_x, 2) / n) * Math.sqrt(sum_y2 - Math.pow(sum_y, 2) / n);
        if (denominator == 0) {
            return 0;
        } else {
            return (sum_xy - (sum_x * sum_y) / n) / denominator;
        }
    }


    /** username��Ŀ���û���userSet��Ŀ���û������Ѽ��� */
    public List<UserSet.Movie> recommend(String username, UserSet userSet) {
        //����Ŀ���û���username��Ŀ���û����ھӼ��ϣ���Ŀ���û��������
        Map<Double, String> distancesMap = computeNearestNeighbor(username, userSet);
        String nearest = distancesMap.values().iterator().next();
        System.out.println("\nnearest -> " + nearest);


        List<UserSet.Movie> recommendations = new ArrayList<>();

        //�ҵ�����ڿ���������Ŀ���û�û�����ĵ�Ӱ�����㲢�Ƽ�
        UserSet.User neighborRatings = userSet.getUserByUsername(nearest);
        System.out.println("\nneighborRatings -> " + neighborRatings.movieArrayList);

        UserSet.User userRatings = userSet.getUserByUsername(username);
        System.out.println("\nuserRatings -> " + userRatings.movieArrayList);

        for (UserSet.Movie artist : neighborRatings.movieArrayList) {
            if (userRatings.findMovieByMovieNameOfMovie(artist.movieName) == null) {
                recommendations.add(artist);
            }
        }
        Collections.sort(recommendations);
        System.out.println("\nrecommendations -> " + recommendations.toString());
        return recommendations;
    }


}
