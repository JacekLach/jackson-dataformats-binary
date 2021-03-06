package com.fasterxml.jackson.dataformat.smile;

import java.io.*;

import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Tests to verify [JACKSON-278]
 */
public class VersionsTest extends BaseTestForSmile
{
    public void testMapperVersions() throws IOException
    {
        final ObjectMapper mapper = smileMapper(false);
        assertVersion(mapper.tokenStreamFactory());
        assertVersion(mapper.createGenerator(new ByteArrayOutputStream()));
        assertVersion(mapper.createParser(new byte[0]));
    }

    /*
    /**********************************************************
    /* Helper methods
    /**********************************************************
     */

    private void assertVersion(Versioned v)
    {
        assertEquals(PackageVersion.VERSION, v.version());
    }
}

