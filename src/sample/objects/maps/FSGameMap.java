package sample.objects.maps;

import sample.abstracts.AbstractGameMap;
import sample.abstracts.AbstractGameObject;
import sample.abstracts.Coordinate;
import sample.enums.GameObjectType;
import sample.patterns.GameObjectCreator;

import java.io.*;

public class FSGameMap  extends AbstractGameMap {
    @Override
    public boolean saveMap(Object source) {
        return false;
    }

    @Override
    public boolean loadMap(Object source) {
        File file = new File(source.toString());

        if (!file.isFile())
            throw new IllegalArgumentException("Wrong filename!");
        try {
            setExitExist(false);
            setGoldManExist(false);

            setHeight(getLineCount(file));

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String strLine = reader.readLine().trim();
            setName(strLine.split(",")[0]);
            setTimeLimit(Integer.parseInt(strLine.split(",")[1]));
            setWidth(Integer.valueOf(strLine.split(",")[2]));
            int y = 0;
            int x = 0;
            while ((strLine = reader.readLine()) != null) {
                x = 0;

                for (String str : strLine.split(",")) {
                    createGameObject(str, new Coordinate(x, y));
                    x++;
                }
                y++;
            }
            if (!isValidMap()) {
                throw new Exception("The map is not valid!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    private void createGameObject(String str, Coordinate coordinate){
        GameObjectType objectType = GameObjectType.valueOf(str.toUpperCase());
        AbstractGameObject gameObject = null;
        try {
            gameObject = GameObjectCreator.getInstance().createObject(objectType, coordinate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        addGameObject(gameObject);

        if(objectType == GameObjectType.EXIT){
            setExitExist(true);
        } else if (objectType == GameObjectType.GOLDMAN) {
            setGoldManExist(true);
        }
    }

    private int getLineCount(File file){
        int lineCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            while(reader.readLine() != null)
                lineCount++;
            lineCount -= 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }

}
