/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monibox.selTestNG.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import java.util.StringTokenizer;

import org.yaml.snakeyaml.Yaml;

/**
 * The Class YamlReader.
 */
@SuppressWarnings("unchecked")
public class YamlReader {

	/** The yaml file path. */
	// public static String yamlFilePath =
	// "src\\test\\resources\\testdata\\TestData.yml";
	public static String yamlFilePath;

	/**
	 * Sets the yaml file path.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the string
	 */
	public static String setYamlFilePath(String filePath) {
		yamlFilePath = "src/test/resources/testdata/" + filePath;
		System.out.println("Yaml File: " + yamlFilePath);
		return yamlFilePath;
	}

	/**
	 * Gets the yaml value.
	 * 
	 * @param token
	 *            the token
	 * @return the yaml value
	 */
	public static String getYamlValue(String token) {
		try {
			return getValue(token).trim();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	/**
	 * Gets the yaml values.
	 * 
	 * @param token
	 *            the token
	 * @return the yaml values
	 */
	public static Map<String, Object> getYamlValues(String token) {
		Reader doc;
		try {
			doc = new FileReader(yamlFilePath);
		} catch (FileNotFoundException ex) {
			System.out.println("File not valid or missing!!!");
			ex.printStackTrace();
			return null;
		}
		Yaml yaml = new Yaml();
		// instance in one place
		Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
		return parseMap(object, token);
	}

	/**
	 * Gets the value.
	 * 
	 * @param token
	 *            the token
	 * @return the value
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	private static String getValue(String token) throws FileNotFoundException {
		Reader doc = new FileReader(yamlFilePath);
		Yaml yaml = new Yaml();
		Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
		return getMapValue(object, token);
	}

	/**
	 * Gets the map value.
	 * 
	 * @param object
	 *            the object
	 * @param token
	 *            the token
	 * @return the map value
	 */
	public static String getMapValue(Map<String, Object> object, String token) {
		String[] st = token.split("\\.");
		return parseMap(object, token).get(st[st.length - 1]).toString();
	}

	/**
	 * Parses the map.
	 * 
	 * @param object
	 *            the object
	 * @param token
	 *            the token
	 * @return the map
	 */
	private static Map<String, Object> parseMap(Map<String, Object> object, String token) {
		if (token.contains(".")) {
			String[] st = token.split("\\.");
			object = parseMap((Map<String, Object>) object.get(st[0]),
							token.replace(st[0] + ".", ""));
		}
		return object;
	}

	/**
	 * Gets the yaml nodes array.
	 * 
	 * @param yamlToken
	 *            the yaml token
	 * @return the yaml nodes array
	 */
	public static Map<String, Object> getYamlNodesArray(String yamlToken) {
		Reader reader = null;
		int tokenCount = 0, i = 0;
		Map<String, Object> map = null;
		StringTokenizer st = new java.util.StringTokenizer(yamlToken + ".x", ".");
		try {
			reader = new FileReader(yamlFilePath);
			Yaml yaml = new Yaml();
			map = (Map<String, Object>) yaml.load(reader);
			tokenCount = st.countTokens();
			for (i = 1; i < tokenCount; i++) {
				String token = st.nextToken();
				map = (Map<String, Object>) map.get(token);
			}
			return map;
		} catch (Exception e) {
			System.out.println("Either Yaml file not found or there is problem with token passed!!!\n"
							+ e);
			return null;
		}
	}

	public static void writeInTempTextFile(String text) {
		Writer output = null;
		File file = new File("temp.txt");
		try {
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readDataFromTempFile() {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("temp.txt"));
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				return sCurrentLine;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
}
