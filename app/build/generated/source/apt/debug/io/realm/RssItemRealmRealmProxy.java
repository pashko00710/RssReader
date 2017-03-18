package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RssItemRealmRealmProxy extends com.snijsure.rssreader.data.storage.realm.RssItemRealm
    implements RealmObjectProxy, RssItemRealmRealmProxyInterface {

    static final class RssItemRealmColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long titleIndex;
        public long publicationDateIndex;
        public long descriptionIndex;
        public long channelIndex;

        RssItemRealmColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.idIndex = getValidColumnIndex(path, table, "RssItemRealm", "id");
            indicesMap.put("id", this.idIndex);
            this.titleIndex = getValidColumnIndex(path, table, "RssItemRealm", "title");
            indicesMap.put("title", this.titleIndex);
            this.publicationDateIndex = getValidColumnIndex(path, table, "RssItemRealm", "publicationDate");
            indicesMap.put("publicationDate", this.publicationDateIndex);
            this.descriptionIndex = getValidColumnIndex(path, table, "RssItemRealm", "description");
            indicesMap.put("description", this.descriptionIndex);
            this.channelIndex = getValidColumnIndex(path, table, "RssItemRealm", "channel");
            indicesMap.put("channel", this.channelIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final RssItemRealmColumnInfo otherInfo = (RssItemRealmColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.titleIndex = otherInfo.titleIndex;
            this.publicationDateIndex = otherInfo.publicationDateIndex;
            this.descriptionIndex = otherInfo.descriptionIndex;
            this.channelIndex = otherInfo.channelIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final RssItemRealmColumnInfo clone() {
            return (RssItemRealmColumnInfo) super.clone();
        }

    }
    private RssItemRealmColumnInfo columnInfo;
    private ProxyState<com.snijsure.rssreader.data.storage.realm.RssItemRealm> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("title");
        fieldNames.add("publicationDate");
        fieldNames.add("description");
        fieldNames.add("channel");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    RssItemRealmRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RssItemRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.snijsure.rssreader.data.storage.realm.RssItemRealm>(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public int realmGet$id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    public void realmSet$id(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public String realmGet$title() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    public void realmSet$title(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$publicationDate() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.publicationDateIndex);
    }

    public void realmSet$publicationDate(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.publicationDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.publicationDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.publicationDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.publicationDateIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$description() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    public void realmSet$description(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$channel() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.channelIndex);
    }

    public void realmSet$channel(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.channelIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.channelIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.channelIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.channelIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("RssItemRealm")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("RssItemRealm");
            realmObjectSchema.add(new Property("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("publicationDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("channel", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("RssItemRealm");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_RssItemRealm")) {
            Table table = sharedRealm.getTable("class_RssItemRealm");
            table.addColumn(RealmFieldType.INTEGER, "id", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.STRING, "title", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "publicationDate", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "description", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "channel", Table.NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_RssItemRealm");
    }

    public static RssItemRealmColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_RssItemRealm")) {
            Table table = sharedRealm.getTable("class_RssItemRealm");
            final long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final RssItemRealmColumnInfo columnInfo = new RssItemRealmColumnInfo(sharedRealm.getPath(), table);

            if (!table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
            } else {
                if (table.getPrimaryKey() != columnInfo.idIndex) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
                }
            }

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("title")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("title") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'title' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.titleIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("publicationDate")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'publicationDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("publicationDate") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'publicationDate' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.publicationDateIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'publicationDate' is required. Either set @Required to field 'publicationDate' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("description")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'description' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("description") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'description' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.descriptionIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'description' is required. Either set @Required to field 'description' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("channel")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'channel' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("channel") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'channel' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.channelIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'channel' is required. Either set @Required to field 'channel' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'RssItemRealm' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_RssItemRealm";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.snijsure.rssreader.data.storage.realm.RssItemRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.snijsure.rssreader.data.storage.realm.RssItemRealm obj = null;
        if (update) {
            Table table = realm.getTable(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RssItemRealmRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.RssItemRealmRealmProxy) realm.createObjectInternal(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RssItemRealmRealmProxy) realm.createObjectInternal(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((RssItemRealmRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((RssItemRealmRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("publicationDate")) {
            if (json.isNull("publicationDate")) {
                ((RssItemRealmRealmProxyInterface) obj).realmSet$publicationDate(null);
            } else {
                ((RssItemRealmRealmProxyInterface) obj).realmSet$publicationDate((String) json.getString("publicationDate"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                ((RssItemRealmRealmProxyInterface) obj).realmSet$description(null);
            } else {
                ((RssItemRealmRealmProxyInterface) obj).realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("channel")) {
            if (json.isNull("channel")) {
                ((RssItemRealmRealmProxyInterface) obj).realmSet$channel(null);
            } else {
                ((RssItemRealmRealmProxyInterface) obj).realmSet$channel((String) json.getString("channel"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.snijsure.rssreader.data.storage.realm.RssItemRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.snijsure.rssreader.data.storage.realm.RssItemRealm obj = new com.snijsure.rssreader.data.storage.realm.RssItemRealm();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((RssItemRealmRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RssItemRealmRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((RssItemRealmRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("publicationDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RssItemRealmRealmProxyInterface) obj).realmSet$publicationDate(null);
                } else {
                    ((RssItemRealmRealmProxyInterface) obj).realmSet$publicationDate((String) reader.nextString());
                }
            } else if (name.equals("description")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RssItemRealmRealmProxyInterface) obj).realmSet$description(null);
                } else {
                    ((RssItemRealmRealmProxyInterface) obj).realmSet$description((String) reader.nextString());
                }
            } else if (name.equals("channel")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RssItemRealmRealmProxyInterface) obj).realmSet$channel(null);
                } else {
                    ((RssItemRealmRealmProxyInterface) obj).realmSet$channel((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.snijsure.rssreader.data.storage.realm.RssItemRealm copyOrUpdate(Realm realm, com.snijsure.rssreader.data.storage.realm.RssItemRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.snijsure.rssreader.data.storage.realm.RssItemRealm) cachedRealmObject;
        } else {
            com.snijsure.rssreader.data.storage.realm.RssItemRealm realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((RssItemRealmRealmProxyInterface) object).realmGet$id());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.RssItemRealmRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.snijsure.rssreader.data.storage.realm.RssItemRealm copy(Realm realm, com.snijsure.rssreader.data.storage.realm.RssItemRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.snijsure.rssreader.data.storage.realm.RssItemRealm) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.snijsure.rssreader.data.storage.realm.RssItemRealm realmObject = realm.createObjectInternal(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class, ((RssItemRealmRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((RssItemRealmRealmProxyInterface) realmObject).realmSet$title(((RssItemRealmRealmProxyInterface) newObject).realmGet$title());
            ((RssItemRealmRealmProxyInterface) realmObject).realmSet$publicationDate(((RssItemRealmRealmProxyInterface) newObject).realmGet$publicationDate());
            ((RssItemRealmRealmProxyInterface) realmObject).realmSet$description(((RssItemRealmRealmProxyInterface) newObject).realmGet$description());
            ((RssItemRealmRealmProxyInterface) realmObject).realmSet$channel(((RssItemRealmRealmProxyInterface) newObject).realmGet$channel());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.snijsure.rssreader.data.storage.realm.RssItemRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
        long tableNativePtr = table.getNativeTablePointer();
        RssItemRealmColumnInfo columnInfo = (RssItemRealmColumnInfo) realm.schema.getColumnInfo(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((RssItemRealmRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RssItemRealmRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((RssItemRealmRealmProxyInterface) object).realmGet$id(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$title = ((RssItemRealmRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$publicationDate = ((RssItemRealmRealmProxyInterface)object).realmGet$publicationDate();
        if (realmGet$publicationDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.publicationDateIndex, rowIndex, realmGet$publicationDate, false);
        }
        String realmGet$description = ((RssItemRealmRealmProxyInterface)object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$channel = ((RssItemRealmRealmProxyInterface)object).realmGet$channel();
        if (realmGet$channel != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.channelIndex, rowIndex, realmGet$channel, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
        long tableNativePtr = table.getNativeTablePointer();
        RssItemRealmColumnInfo columnInfo = (RssItemRealmColumnInfo) realm.schema.getColumnInfo(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.snijsure.rssreader.data.storage.realm.RssItemRealm object = null;
        while (objects.hasNext()) {
            object = (com.snijsure.rssreader.data.storage.realm.RssItemRealm) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((RssItemRealmRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RssItemRealmRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((RssItemRealmRealmProxyInterface) object).realmGet$id(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$title = ((RssItemRealmRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$publicationDate = ((RssItemRealmRealmProxyInterface)object).realmGet$publicationDate();
                if (realmGet$publicationDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.publicationDateIndex, rowIndex, realmGet$publicationDate, false);
                }
                String realmGet$description = ((RssItemRealmRealmProxyInterface)object).realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
                }
                String realmGet$channel = ((RssItemRealmRealmProxyInterface)object).realmGet$channel();
                if (realmGet$channel != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.channelIndex, rowIndex, realmGet$channel, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.snijsure.rssreader.data.storage.realm.RssItemRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
        long tableNativePtr = table.getNativeTablePointer();
        RssItemRealmColumnInfo columnInfo = (RssItemRealmColumnInfo) realm.schema.getColumnInfo(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((RssItemRealmRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RssItemRealmRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((RssItemRealmRealmProxyInterface) object).realmGet$id(), false);
        }
        cache.put(object, rowIndex);
        String realmGet$title = ((RssItemRealmRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$publicationDate = ((RssItemRealmRealmProxyInterface)object).realmGet$publicationDate();
        if (realmGet$publicationDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.publicationDateIndex, rowIndex, realmGet$publicationDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.publicationDateIndex, rowIndex, false);
        }
        String realmGet$description = ((RssItemRealmRealmProxyInterface)object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$channel = ((RssItemRealmRealmProxyInterface)object).realmGet$channel();
        if (realmGet$channel != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.channelIndex, rowIndex, realmGet$channel, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.channelIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
        long tableNativePtr = table.getNativeTablePointer();
        RssItemRealmColumnInfo columnInfo = (RssItemRealmColumnInfo) realm.schema.getColumnInfo(com.snijsure.rssreader.data.storage.realm.RssItemRealm.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.snijsure.rssreader.data.storage.realm.RssItemRealm object = null;
        while (objects.hasNext()) {
            object = (com.snijsure.rssreader.data.storage.realm.RssItemRealm) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((RssItemRealmRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RssItemRealmRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((RssItemRealmRealmProxyInterface) object).realmGet$id(), false);
                }
                cache.put(object, rowIndex);
                String realmGet$title = ((RssItemRealmRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$publicationDate = ((RssItemRealmRealmProxyInterface)object).realmGet$publicationDate();
                if (realmGet$publicationDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.publicationDateIndex, rowIndex, realmGet$publicationDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.publicationDateIndex, rowIndex, false);
                }
                String realmGet$description = ((RssItemRealmRealmProxyInterface)object).realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
                }
                String realmGet$channel = ((RssItemRealmRealmProxyInterface)object).realmGet$channel();
                if (realmGet$channel != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.channelIndex, rowIndex, realmGet$channel, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.channelIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.snijsure.rssreader.data.storage.realm.RssItemRealm createDetachedCopy(com.snijsure.rssreader.data.storage.realm.RssItemRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.snijsure.rssreader.data.storage.realm.RssItemRealm unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.snijsure.rssreader.data.storage.realm.RssItemRealm)cachedObject.object;
            } else {
                unmanagedObject = (com.snijsure.rssreader.data.storage.realm.RssItemRealm)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.snijsure.rssreader.data.storage.realm.RssItemRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((RssItemRealmRealmProxyInterface) unmanagedObject).realmSet$id(((RssItemRealmRealmProxyInterface) realmObject).realmGet$id());
        ((RssItemRealmRealmProxyInterface) unmanagedObject).realmSet$title(((RssItemRealmRealmProxyInterface) realmObject).realmGet$title());
        ((RssItemRealmRealmProxyInterface) unmanagedObject).realmSet$publicationDate(((RssItemRealmRealmProxyInterface) realmObject).realmGet$publicationDate());
        ((RssItemRealmRealmProxyInterface) unmanagedObject).realmSet$description(((RssItemRealmRealmProxyInterface) realmObject).realmGet$description());
        ((RssItemRealmRealmProxyInterface) unmanagedObject).realmSet$channel(((RssItemRealmRealmProxyInterface) realmObject).realmGet$channel());
        return unmanagedObject;
    }

    static com.snijsure.rssreader.data.storage.realm.RssItemRealm update(Realm realm, com.snijsure.rssreader.data.storage.realm.RssItemRealm realmObject, com.snijsure.rssreader.data.storage.realm.RssItemRealm newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((RssItemRealmRealmProxyInterface) realmObject).realmSet$title(((RssItemRealmRealmProxyInterface) newObject).realmGet$title());
        ((RssItemRealmRealmProxyInterface) realmObject).realmSet$publicationDate(((RssItemRealmRealmProxyInterface) newObject).realmGet$publicationDate());
        ((RssItemRealmRealmProxyInterface) realmObject).realmSet$description(((RssItemRealmRealmProxyInterface) newObject).realmGet$description());
        ((RssItemRealmRealmProxyInterface) realmObject).realmSet$channel(((RssItemRealmRealmProxyInterface) newObject).realmGet$channel());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("RssItemRealm = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{publicationDate:");
        stringBuilder.append(realmGet$publicationDate() != null ? realmGet$publicationDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{channel:");
        stringBuilder.append(realmGet$channel() != null ? realmGet$channel() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RssItemRealmRealmProxy aRssItemRealm = (RssItemRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRssItemRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRssItemRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRssItemRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
