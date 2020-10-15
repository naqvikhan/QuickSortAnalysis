import java.util.*;

public class Main 
{

    public static void main(String[] args) 
    {
        
        int[] sizeOfArray = {100, 1000, 10000};


        for(int i = 0; i < sizeOfArray.length; i++) 
        {
			int[] elements= algorithmAnalysisArray(sizeOfArray[i]);

			double startTime = System.nanoTime();
			quickSort(elements,0, elements.length -1);
			double lastElementTime = System.nanoTime();
            		double elapsedTime = lastElementTime - startTime;
            
    		PrintTime(startTime, lastElementTime, elapsedTime, sizeOfArray[i]);	
        }

	}

    public static void swap(int[] elements, int i, int j)
    {
        int temp= elements[i];
		elements[i] = elements[j];
		elements[j] = temp;	
	}


    //Partition Algorithm
    public static int partition(int[] elements, int firstElement, int lastElement)
    {

		int random=firstElement + ((int)Math.random()*(elements.length))/(lastElement-firstElement+1);
		int last=lastElement;

		swap(elements, random, lastElement);
		lastElement--;

            while(firstElement<=lastElement)
            {
                if(elements[firstElement]<elements[last]) firstElement++; 
                else 
                {
                    swap(elements, firstElement, lastElement);
                    lastElement--;
                }
            }
        swap(elements, firstElement, last);
        
		return firstElement;
	}

    //Quick Sort Algorithm
    public static void quickSort(int[] elements, int firstElement, int lastElement)
    {
        if(firstElement>=lastElement) 
        return;

        if(firstElement<0) 
        return;

        if(lastElement>elements.length - 1) 
        return;

		int pivot = partition(elements, firstElement, lastElement);
		quickSort(elements, firstElement, pivot-1);
		quickSort(elements, pivot+1, lastElement);
	}

    public static int[] algorithmAnalysisArray(int sizeOfData) 
    {
		int[] tempData = new int[sizeOfData];
		
        for(int i=0;i<tempData.length;i++) 
        {
			tempData[i] = i;	
		}
        
        return tempData; 

    }
    
    public static void PrintTime(double start, double lastElement, double elapsedTime, int size) {
		
		System.out.println("Size of Array: " + size+ "\n");
		System.out.println("Randomized-QuickSort Algorithm initialized at time: "+start);
		System.out.println("Randomized-QuickSort Algorithm ended at time "+lastElement);
		System.out.println("Total Time Elapsed: " + elapsedTime +" ns\n\n\n");
	}
}
