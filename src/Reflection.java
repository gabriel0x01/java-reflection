

import java.lang.reflect.Field;

public class Reflection {
	public static String toXML(Object object) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("<" + object.getClass().getSimpleName() + ">\n");
		
		
		Field[] atributos = object.getClass().getDeclaredFields();
		
		for (Field atributo : atributos) {
			
			if(!atributo.canAccess(object))
				atributo.setAccessible(true);
			
			switch (atributo.getType().getName()) {
			case "int":
			case "double":
			case "float":
			case "java.lang.String":
				stringBuilder.append("<" + atributo.getName() + ">" + atributo.get(object) + "</" + atributo.getName() + ">\n");
				break;
			default: // definicao recursiva se for um objeto;
				stringBuilder.append(toXML(atributo.get(object)));
			}		
		}
		
		stringBuilder.append("</" + object.getClass().getSimpleName() + ">\n");
		
		return stringBuilder.toString();
		
	}
	
	public static String formatterXML(Object object) throws Exception {
		return "<xml version=\"1.0\">\n" + toXML(object) + "</xml>";
	}
}
