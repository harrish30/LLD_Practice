package LLD2.observer;

import java.util.ArrayList;
import java.util.List;

public class Amazon
{
    private static Amazon instance;
    public static Amazon getInstance()
    {
        if(instance == null)
        {
            synchronized(Amazon.class)
            {
                if(instance == null)
                {
                    instance = new Amazon();
                }
            }

        }
        return instance;
    }
    List<OrderPlacedSubscriber> list;
    private Amazon()
    {
        list = new ArrayList<>();
    }
    public void orderPlaced()
    {
        for(OrderPlacedSubscriber i : list)
        {
            i.orderPlaceEvent();
        }
    }
    public void subscribe(OrderPlacedSubscriber iOrderPlacedSubscriber)
    {
        list.add(iOrderPlacedSubscriber);
    }
    public void unsubscribe(OrderPlacedSubscriber iOrderPlacedSubscriber)
    {
        list.remove(iOrderPlacedSubscriber);
    }
}
